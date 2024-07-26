package com.example.poc.flow.processor.impl;

import com.example.poc.flow.model.base.BaseContext;
import com.example.poc.flow.model.base.Transaction;
import com.example.poc.flow.model.context.MessageFlowDto;
import com.example.poc.flow.model.dto.MessageFlowTrackerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Slf4j
public class LegCreationProcessor extends AbstractProcessor {
    @Override
    public BaseContext execute(final BaseContext baseContext) {
        super.execute(baseContext);
        Transaction transaction = getLatestTransaction(baseContext);
        if (Objects.nonNull(transaction)) {
            log.info("Going to create legs for {}", transaction.getMessageData().getLegs());
            for (String leg : transaction.getMessageData().getLegs()) {
                MessageFlowTrackerDTO messageFlowDto = new MessageFlowTrackerDTO();
                messageFlowDto.setLegType(leg);
                transaction.getMessageFlows().add(messageFlowDto);
            }
        }
        return baseContext;
    }


}
