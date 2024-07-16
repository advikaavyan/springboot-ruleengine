package com.example.poc.flow.processor.impl;

import com.example.poc.flow.model.base.BaseContext;
import com.example.poc.flow.model.base.Transaction;
import com.example.poc.flow.model.context.MessageFlowDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Slf4j
public class StateTransitioningProcessor extends AbstractProcessor {
    @Override
    public BaseContext execute(final BaseContext baseContext) {
        Transaction latestTransaction = getLatestTransaction(baseContext);
        if (Objects.nonNull(latestTransaction)) {
            for (MessageFlowDto messageFlowDto : latestTransaction.getMessageFlows()) {

            }
        }

        return baseContext;
    }
}
