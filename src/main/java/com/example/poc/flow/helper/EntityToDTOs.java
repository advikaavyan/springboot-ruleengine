package com.example.poc.flow.helper;

import com.example.poc.flow.mapper.InboundMessageMapper;
import com.example.poc.flow.mapper.MessageFlowTrackerMapper;
import com.example.poc.flow.model.base.Transaction;
import com.example.poc.flow.model.base.impl.StpTransactionImpl;
import com.example.poc.flow.model.dto.InboundMessageDTO;
import com.example.poc.flow.model.entity.MatchingSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class EntityToDTOs {

    @Autowired
    InboundMessageMapper inboundMessageMapper;
    @Autowired
    MessageFlowTrackerMapper messageFlowTrackerMapper;

    public Transaction toTransaction(MatchingSignature matchingSignature) {

        InboundMessageDTO inboundMessageDTO = inboundMessageMapper.toDTO(matchingSignature.getInboundMessage());

        Transaction transaction = StpTransactionImpl.builder().inboundMessageDTO(inboundMessageDTO).build();


        return transaction;

    }
}
