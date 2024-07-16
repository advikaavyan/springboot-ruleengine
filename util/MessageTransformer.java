package com.example.advikaavyan.adaptor.util;

public class MessageTransformer {

    /*public static IncomingMessage toIncomingMessage(InMessage inMessage) {
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
    }*/
    // Map to DTO

}
