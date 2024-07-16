package com.example.poc.flow.impl;

import com.example.poc.flow.Flow;
import com.example.poc.flow.model.base.BaseContext;
import com.example.poc.flow.model.base.Message;
import com.example.poc.flow.processor.ContextBuilder;
import com.example.poc.flow.processor.impl.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
public class STPFlow implements Flow {
    private final ContextBuilder contextBuilder;
    private final MatchingProcessor matchingProcessor;
    private final StateTransitioningProcessor stateTransitioningProcessor;
    private final LegCreationProcessor legCreationProcessor;
    private final NavHolProcessor navHolProcessor;
    private final OutboundProcessor outboundProcessor;
    private final PersistProcessor persistProcessor;
    private final PublishProcessor publishProcessor;

    public STPFlow(ContextBuilder contextBuilder, MatchingProcessor matchingProcessor, StateTransitioningProcessor stateTransitioningProcessor,
                   LegCreationProcessor legCreationProcessor, NavHolProcessor navHolProcessor, OutboundProcessor outboundProcessor, PersistProcessor persistProcessor,
                   PublishProcessor publishProcessor) {

        this.contextBuilder = contextBuilder;
        this.matchingProcessor = matchingProcessor;
        this.stateTransitioningProcessor = stateTransitioningProcessor;
        this.legCreationProcessor = legCreationProcessor;
        this.navHolProcessor = navHolProcessor;
        this.outboundProcessor = outboundProcessor;
        this.persistProcessor = persistProcessor;
        this.publishProcessor = publishProcessor;
    }

    @Override
    @Transactional
    public void executeMessageFlow(Message message) {

        BaseContext baseContext = contextBuilder.buildContext(message);
        log.info("baseContext={}", baseContext);

        baseContext = matchingProcessor.execute(baseContext);
        baseContext = stateTransitioningProcessor.execute(baseContext);
        baseContext = legCreationProcessor.execute(baseContext);

        baseContext = navHolProcessor.execute(baseContext);
        baseContext = stateTransitioningProcessor.execute(baseContext);

        baseContext = outboundProcessor.execute(baseContext);
        baseContext = persistProcessor.execute(baseContext);
        baseContext = publishProcessor.execute(baseContext);

    }

}
