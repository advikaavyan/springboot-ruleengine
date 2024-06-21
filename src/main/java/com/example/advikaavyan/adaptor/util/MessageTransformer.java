package com.example.advikaavyan.adaptor.util;

import com.example.advikaavyan.adaptor.dto.InMessage;
import com.example.advikaavyan.adaptor.dto.InMessageResponse;
import com.example.advikaavyan.adaptor.dto.OutMessage;
import com.example.advikaavyan.adaptor.entity.IncomingMessage;

import java.util.stream.Collectors;

public class MessageTransformer {

    public static IncomingMessage toIncomingMessage(InMessage inMessage) {
        IncomingMessage incomingMessage = new IncomingMessage();
        incomingMessage.setMessage(inMessage.getMessage());
        incomingMessage.setSource(inMessage.getSource());
        return incomingMessage;
    }

    public static InMessageResponse toIncomingMessage(IncomingMessage incomingMessage) {
        InMessageResponse inMessageResponse = new InMessageResponse();

        inMessageResponse.setMessageId(incomingMessage.getMessageId());
        inMessageResponse.setSource(incomingMessage.getSource());
        inMessageResponse.setMessage(incomingMessage.getMessage());
        inMessageResponse.setReceivedAt(incomingMessage.getReceivedAt());
        inMessageResponse.setOutMessages(
                incomingMessage.getOutgoingMessages().stream().map(outgoingMessage -> {
                    OutMessage outMessage = new OutMessage();
                    outMessage.setMessageId(outgoingMessage.getMessageId());
                    outMessage.setMessageType(outgoingMessage.getMessageType());
                    outMessage.setMessage(outgoingMessage.getMessage());
                    outMessage.setCreatedAt(outgoingMessage.getCreatedAt());
                    return outMessage;
                }).collect(Collectors.toList())
        );
        return inMessageResponse;
    }
    // Map to DTO

}
