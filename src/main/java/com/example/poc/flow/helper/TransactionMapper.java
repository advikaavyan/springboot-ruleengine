package com.example.poc.flow.helper;

import com.example.poc.flow.mapper.InboundMessageMapper;
import com.example.poc.flow.mapper.MessageDataMapper;
import com.example.poc.flow.mapper.MessageFlowTrackerMapper;
import com.example.poc.flow.model.base.Transaction;
import com.example.poc.flow.model.base.impl.StpTransactionImpl;
import com.example.poc.flow.model.context.Navhold;
import com.example.poc.flow.model.dto.InboundMessageDTO;
import com.example.poc.flow.model.dto.MessageDataDTO;
import com.example.poc.flow.model.dto.MessageFlowTrackerDTO;
import com.example.poc.flow.model.entity.MatchingSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class TransactionMapper {

    @Autowired
    InboundMessageMapper inboundMessageMapper;
    @Autowired
    MessageFlowTrackerMapper messageFlowTrackerMapper;

    @Autowired
    MessageDataMapper messageDataMapper;

    public Transaction toTransaction(MatchingSignature matchingSignature) {

        InboundMessageDTO inboundMessageDTO = inboundMessageMapper.toDTO(matchingSignature.getInboundMessage());
        List<MessageFlowTrackerDTO> messageFlowTrackerDTOS = messageFlowTrackerMapper.toDTO(matchingSignature.getInboundMessage().getMessageFlowTrackers());
        MessageDataDTO messageDataDTO = messageDataMapper.toMessageDataDTO(matchingSignature.getInboundMessage().getInMessage());
        Transaction transaction = StpTransactionImpl.builder()
                .inboundMessageDTO(inboundMessageDTO)
                .messageFlows(messageFlowTrackerDTOS)
                .messageData(messageDataDTO)
                .navhold(new Navhold())
                .matchingSignatureDTOS(List.of())
                .build();


        return transaction;

    }

    public Transaction toTransaction111(MatchingSignature matchingSignature) {
        //   DynamicTablePrinter.printDTOs(List.of(matchingSignature));
        InboundMessageDTO inboundMessageDTO = inboundMessageMapper.toDTO(matchingSignature.getInboundMessage());
        List<MessageFlowTrackerDTO> messageFlowTrackerDTOS = messageFlowTrackerMapper.toDTO(matchingSignature.getInboundMessage().getMessageFlowTrackers());
        // MessageDataDTO messageDataDTO = messageDataMapper.toDTO(matchingSignature.getInboundMessage().getMessageData());
        Transaction transaction = StpTransactionImpl.builder()
                .inboundMessageDTO(inboundMessageDTO)
                .messageFlows(messageFlowTrackerDTOS)
                // .messageData(messageDataDTO)
                .navhold(new Navhold())
                .matchingSignatureDTOS(List.of())
                .build();


        return transaction;

    }
}
