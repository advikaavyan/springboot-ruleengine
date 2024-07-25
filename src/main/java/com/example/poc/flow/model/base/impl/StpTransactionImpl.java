package com.example.poc.flow.model.base.impl;

import com.example.poc.flow.model.base.Transaction;
import com.example.poc.flow.model.context.Navhold;
import com.example.poc.flow.model.dto.*;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class StpTransactionImpl implements Transaction {
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