package com.example.poc.flow.model.base;


import com.example.poc.flow.model.context.Navhold;
import com.example.poc.flow.model.dto.*;

import java.util.List;

public interface Transaction {
    MessageDataDTO getMessageData();

    Navhold getNavhold();

    InboundMessageDTO getInboundMessageDTO();

    List<MessageFlowTrackerDTO> getMessageFlows();

    List<OutboundMessageDTO> getOutbounds();

    List<MatchingSignatureDTO> getMatchingSignatures();
}
