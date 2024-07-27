package com.example.poc.flow.processor.impl;


import com.example.poc.flow.model.base.*;
import com.example.poc.flow.model.base.impl.StpContext;
import com.example.poc.flow.model.base.impl.StpTransactionImpl;
import com.example.poc.flow.model.base.impl.TransactionCollectionImpl;
import com.example.poc.flow.model.context.Navhold;
import com.example.poc.flow.model.dto.InboundMessageDTO;
import com.example.poc.flow.model.dto.MessageDataDTO;
import com.example.poc.flow.processor.ContextBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Slf4j
public class STPContextBuilder implements ContextBuilder {
    @Override
    public BaseContext buildContext(Message message) {
        log.info("Inside STPContextBuilder");
        MessageDataDTO messageDataDTO = toMessageDataDTO(message);
        BaseContext baseContext = createContext(messageDataDTO);
        return baseContext;
    }

    private BaseContext createContext(MessageDataDTO messageDataDTO) {
        BaseContext baseContext = StpContext.builder().build();
        TransactionCollection transactionCollection = new TransactionCollectionImpl();
        
        Transaction transaction = StpTransactionImpl.builder()
                .messageData(messageDataDTO)
                .inboundMessageDTO(new InboundMessageDTO())
                .messageFlows(new ArrayList<>())
                .matchingSignatureDTOS(new ArrayList<>())
                .navhold(new Navhold())
                .outbounds(new ArrayList<>())
                .build();

        transactionCollection.appendTransaction(transaction);
        baseContext.addTransactions(TransactionKey.valueOf(messageDataDTO.getMessageFunction()), transactionCollection);
        return baseContext;
    }

    private MessageDataDTO toMessageDataDTO(Message<String> message) {
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        MessageDataDTO message1 = null;
        try {
            message1 = objectMapper.readValue(message.getContent(), MessageDataDTO.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        message1.setRawMessage(message.getContent());
        return message1;

    }

}
