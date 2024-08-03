package com.example.advikaavyan.adaptor.mycode;

import com.example.advikaavyan.adaptor.dto.MessageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MessageProcessingService {

    @Autowired
    IncomingMessageService incomingMessageService;

    @Transactional
    public String processIncomingMessage(String xmlMessage) {
       // MessageData messageData = XMLParser.parseXmlMessage(xmlMessage);

        MessageData messageData = new MessageData();
        messageData.setMessage(xmlMessage);
        messageData.setUuid("123");
        incomingMessageService.processIncomingMessage(messageData);
        return "YES";

    }
}
