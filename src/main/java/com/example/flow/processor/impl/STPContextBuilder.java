package com.example.flow.processor.impl;


import com.example.flow.model.base.*;
import com.example.flow.model.base.impl.StpContext;
import com.example.flow.model.base.impl.TransactionCollectionImpl;
import com.example.flow.model.context.*;
import com.example.flow.processor.ContextBuilder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class STPContextBuilder implements ContextBuilder {
    @Override
    public BaseContext buildContext(Message message) {
        MessageDataDto messageDataDto = (MessageDataDto) message.getContent();
        BaseContext baseContext = createContext(messageDataDto);
        return baseContext;
    }

    private BaseContext createContext(MessageDataDto messageDataDto) {
        BaseContext baseContext = StpContext.builder().build();
        TransactionCollection transactionCollection = new TransactionCollectionImpl();
        TransactionImpl transaction = new TransactionImpl();
        transaction.setMessageData(messageDataDto);
        transactionCollection.appendTransaction(transaction);
        baseContext.addTransactions(TransactionKey.valueOf("A"), transactionCollection);
        return baseContext;
    }

    @Data
    private class TransactionImpl implements Transaction {
        private MessageDataDto messageData;
        private Navhold navhold;
        private IncomingMessageDto incomingMessage;
        private List<MessageFlowDto> messageFlows;
        private List<OutboundDto> outbounds;
        private List<SignatureDto> signatures;

        @Override
        public MessageDataDto getMessageData() {
            return messageData;
        }

        @Override
        public Navhold getNavhold() {
            return navhold;
        }

        @Override
        public IncomingMessageDto getIncomingMessageDto() {
            return incomingMessage;
        }

        @Override
        public List<MessageFlowDto> getMessageFlows() {
            return messageFlows;
        }

        @Override
        public List<OutboundDto> getOutbounds() {
            return outbounds;
        }

        @Override
        public List<SignatureDto> getSignatures() {
            return signatures;
        }
    }
}
