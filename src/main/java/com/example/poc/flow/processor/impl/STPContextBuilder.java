package com.example.poc.flow.processor.impl;


import com.example.poc.flow.model.base.*;
import com.example.poc.flow.model.base.impl.StpContext;
import com.example.poc.flow.model.base.impl.TransactionCollectionImpl;
import com.example.poc.flow.model.context.Navhold;
import com.example.poc.flow.model.dto.*;
import com.example.poc.flow.processor.ContextBuilder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class STPContextBuilder implements ContextBuilder {
    @Override
    public BaseContext buildContext(Message message) {
        MessageDataDTO messageDataDTO = (MessageDataDTO) message.getContent();
        BaseContext baseContext = createContext(messageDataDTO);
        return baseContext;
    }

    private BaseContext createContext(MessageDataDTO messageDataDTO) {
        BaseContext baseContext = StpContext.builder().build();
        TransactionCollection transactionCollection = new TransactionCollectionImpl();
        TransactionImpl transaction = new TransactionImpl();
        transaction.setMessageData(messageDataDTO);
        transactionCollection.appendTransaction(transaction);
        baseContext.addTransactions(TransactionKey.valueOf(messageDataDTO.getMessageFunction()), transactionCollection);
        return baseContext;
    }

    @Data
    private class TransactionImpl implements Transaction {
        private MessageDataDTO messageData;
        private Navhold navhold = new Navhold();
        private InboundMessageDTO inboundMessageDTO;
        private List<MessageFlowTrackerDTO> messageFlows = new ArrayList<>();
        private List<OutboundMessageDTO> outbounds = new ArrayList<>();
        private List<MatchingSignatureDTO> matchingSignatureDTOS = new ArrayList<>();

        @Override
        public MessageDataDTO getMessageData() {
            return messageData;
        }

        @Override
        public Navhold getNavhold() {
            return navhold;
        }

        @Override
        public InboundMessageDTO getInboundMessageDTO() {
            return inboundMessageDTO;
        }

        @Override
        public List<MessageFlowTrackerDTO> getMessageFlows() {
            return messageFlows;
        }

        @Override
        public List<OutboundMessageDTO> getOutbounds() {
            return outbounds;
        }

        @Override
        public List<MatchingSignatureDTO> getMatchingSignatures() {
            return matchingSignatureDTOS;
        }
    }
}
