package com.example.advikaavyan.adaptor.service;

import com.example.advikaavyan.adaptor.util.MessageTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

  /*  private final IncomingMessageRepository incomingMessageRepository;
    private final OutgoingMessageRepository outgoingMessageRepository;

    @Autowired
    public MessageService(IncomingMessageRepository incomingMessageRepository, OutgoingMessageRepository outgoingMessageRepository) {
        this.incomingMessageRepository = incomingMessageRepository;
        this.outgoingMessageRepository = outgoingMessageRepository;
    }

    @Transactional
    public InMessageResponse saveIncomingAndOutgoingMessages(InMessage inMessage) {
       *//* for (OutgoingMessage outgoingMessage : incomingMessage.getOutgoingMessages()) {
            outgoingMessage.setIncomingMessage(incomingMessage);
        }*//*
        IncomingMessage incomingMessage = MessageTransformer.toIncomingMessage(inMessage);
        incomingMessage.setOutgoingMessages(generateOutgoingMessages(incomingMessage));
        IncomingMessage savedIncomingMessage = incomingMessageRepository.save(incomingMessage);
        return MessageTransformer.toIncomingMessage(savedIncomingMessage);
    }

    public List<OutgoingMessage> generateOutgoingMessages(IncomingMessage incomingMessage) {
        List<OutgoingMessage> outgoingMessages = new ArrayList<>();
        outgoingMessages.add(getOut(incomingMessage, 1, "MOBILE"));
        outgoingMessages.add(getOut(incomingMessage, 2, "MONEY"));
        return outgoingMessages;
    }

    public OutgoingMessage getOut(IncomingMessage incomingMessage, int index, String type) {
        OutgoingMessage outgoingMessage = new OutgoingMessage();
        outgoingMessage.setMessageType(type);
        outgoingMessage.setMessage(incomingMessage.getMessage() + ": " + index);
        outgoingMessage.setIncomingMessage(incomingMessage  );
        return outgoingMessage;
    }*/
}
