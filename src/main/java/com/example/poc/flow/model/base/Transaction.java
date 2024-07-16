package com.example.poc.flow.model.base;



import com.example.poc.flow.model.context.*;

import java.util.List;

public interface Transaction {
    MessageDataDto getMessageData();
    Navhold getNavhold();
    IncomingMessageDto getIncomingMessageDto();

    List<MessageFlowDto> getMessageFlows();

    List<OutboundDto> getOutbounds();

    List<SignatureDto> getSignatures();
}
