package com.example.flow.model.base;


import com.example.flow.model.context.*;

import java.util.List;

public interface Transaction {
    MessageDataDto getMessageData();
    Navhold getNavhold();
    IncomingMessageDto getIncomingMessageDto();

    List<MessageFlowDto> getMessageFlows();

    List<OutboundDto> getOutbounds();

    List<SignatureDto> getSignatures();
}
