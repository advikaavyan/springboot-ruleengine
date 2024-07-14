package com.example.advikaavyan.adaptor.service;

import com.example.advikaavyan.adaptor.model.dto.MessageDTO;
import com.example.advikaavyan.adaptor.dao.SignatureRepository;
import com.example.advikaavyan.adaptor.dao.IncomingMessageRepository;
import com.example.advikaavyan.adaptor.dao.MessageFlowTrackerRepository;
import com.example.advikaavyan.adaptor.dao.OutgoingMessageRepository;
import com.example.advikaavyan.adaptor.entity.IncomingMessage;
import com.example.advikaavyan.adaptor.entity.MessageFlowTracker;
import com.example.advikaavyan.adaptor.entity.OutgoingMessage;
import com.example.advikaavyan.adaptor.entity.Signature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private IncomingMessageRepository incomingMessageRepository;

    @Autowired
    private SignatureRepository signatureRepository;

    @Autowired
    private MessageFlowTrackerRepository messageFlowTrackerRepository;

    @Autowired
    private OutgoingMessageRepository outgoingMessageRepository;

    @Transactional
    public IncomingMessage processMessage(MessageDTO messageDTO) {
        IncomingMessage incomingMessage = new IncomingMessage();
        incomingMessage.setMessageIdentifier(messageDTO.getMessageIdentifier());
        incomingMessage.setSource(messageDTO.getSource());
        incomingMessage.setMessageIdentifier("TMS001");
        // incomingMessage.setReceivedAt(Timestamp.valueOf(messageDTO.getReceivedAt()));
        incomingMessage.setMessage(messageDTO.getMessage());
        List<Signature> signatures = createSign(incomingMessage);
        incomingMessage.setSignatures(signatures);
        List<MessageFlowTracker> messageFlowTrackers = createMessageFlowTracker(incomingMessage);
        createOutgoingMessages(incomingMessage, messageFlowTrackers);
        incomingMessage.setMessageFlowTrackers(messageFlowTrackers); // both lines worked
        incomingMessageRepository.save(incomingMessage);

        //createSign(incomingMessage);
        //createMessageFlowTracker(incomingMessage);


       /* for (SignatureDTO signatureDTO : messageDTO.getSignatures()) {
            Signature signature = new Signature();
            signature.setIncomingMessage(incomingMessage);
            signature.setKey(signatureDTO.getKey());
            signature.setValue(signatureDTO.getValue());
           // signature.setCreatedAt(Timestamp.valueOf(signatureDTO.getCreatedAt()));
            signatureRepository.save(signature);
        }

        for (LegDTO legDTO : messageDTO.getLegs()) {
            MessageFlowTracker tracker = new MessageFlowTracker();
            tracker.setIncomingMessage(incomingMessage);
            tracker.setLegType(legDTO.getLegType());
            tracker.setStatus(legDTO.getStatus());
            tracker.setSubStatus(legDTO.getSubStatus());
           // tracker.setCreatedAt(Timestamp.valueOf(legDTO.getCreatedAt()));
            tracker.setInFlight(legDTO.isInFlight());
            messageFlowTrackerRepository.save(tracker);
        }*/
        return incomingMessage;
    }

    public void updateRecord(Long id, String status) {
        MessageFlowTracker tracker = messageFlowTrackerRepository.findById(id).orElseThrow();
        tracker.setStatus(status);
        messageFlowTrackerRepository.save(tracker);
    }

    public void updateRecord1(Long id) {
      //  IncomingMessage tracker = incomingMessageRepository.getReferenceById(id);
        MessageFlowTracker messageFlowTracker = messageFlowTrackerRepository.getReferenceById(id);
        OutgoingMessage outgoingMessage = new OutgoingMessage();

        outgoingMessage.setLegType(messageFlowTracker.getLegType());
        outgoingMessage.setOutgoingMessage("  ONLY NEW RECORD ADDED BY REST UPDATED VIA : OUT=== ");
        outgoingMessage.setMessageFlowTracker(messageFlowTracker);
        outgoingMessage.setMessageFlowTracker(messageFlowTracker);
        outgoingMessageRepository.save(outgoingMessage);
    }
    public void updateRecord(Long id) {
        //IncomingMessage incomingMessage = incomingMessageRepository.getReferenceById(id);
        MessageFlowTracker messageFlowTracker = messageFlowTrackerRepository.getReferenceById(id);
        OutgoingMessage outgoingMessage = new OutgoingMessage();
        System.out.println(messageFlowTracker.getIncomingMessage().getMessageId());
        System.out.println(messageFlowTracker.getIncomingMessage().getMessage());
        outgoingMessage.setLegType(messageFlowTracker.getLegType());
        outgoingMessage.setOutgoingMessage("  ONLY NEW RECORD ADDED BY REST UPDATED VIA : OUT=== ");
        outgoingMessage.setMessageFlowTracker(messageFlowTracker);
        outgoingMessage.setMessageFlowTracker(messageFlowTracker);
        outgoingMessageRepository.save(outgoingMessage);
    }

    private List<Signature> createSign(IncomingMessage incomingMessage) {
        List<Signature> signatures = new ArrayList<>();
        for (int i = 1; i < 5; i++) {

            Signature signature = new Signature();
            signature.setSignatureKey("DUPE KEY " + i);
            signature.setSignatureValue("VALUE " + i);
            signature.setIncomingMessage(incomingMessage);
            // java.sql.SQLSyntaxErrorException: Table 'adaptor_auto.incoming_message' doesn't exist
            //if   added below  signature.setIncomingMessage(incomingMessage);


        /*    in context with path [] threw exception [Request processing failed: org.springframework.dao.InvalidDataAccessResourceUsageException: could not execute statement [You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'key,value) values (2,'DUPE KEY3','VALUE 3')' at line 1] [insert into Signature (Message_ID,key,value) values (?,?,?)]; SQL [insert into Signature (Message_ID,key,value) values (?,?,?)]] with root cause

            java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'key,value) values (2,'DUPE KEY3','VALUE 3')' at line 1
            at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:120) ~[mysql-connector-j-8.0.31.jar:8.0.31]*/
            //'key,value key and value avoid to  create a table columns


            signatures.add(signature);


        }
        return signatures;
    }

    private List<MessageFlowTracker> createMessageFlowTracker(IncomingMessage incomingMessage) {
        List<MessageFlowTracker> signatures = new ArrayList<>();
        for (int i = 1; i < 5; i++) {

            MessageFlowTracker signature = new MessageFlowTracker();

            signature.setLegType("Asset " + i);
            if(i%2 == 0){
                signature.setStatus("ON_HOLD " + i);
                signature.setSubStatus("HELD" + i);
            }else{
                signature.setStatus("SENT " + i);
                signature.setSubStatus("SENT" + i);
            }

            // when below was not added throwing org.hibernate.PropertyValueException: not-null property references a null or transient value : com.example.advikaavyan.adaptor.entity.MessageFlowTracker.incomingMessage
            signature.setIncomingMessage(incomingMessage);
            signatures.add(signature);
        }
        return signatures;
    }

    private void createOutgoingMessages(IncomingMessage incomingMessage, List<MessageFlowTracker> messageFlowTrackers) {
        List<OutgoingMessage> outgoingMessages = new ArrayList<>();
        for (MessageFlowTracker messageFlowTracker : messageFlowTrackers){
             if(!messageFlowTracker.getStatus().contains("ON_HOLD")){
                OutgoingMessage outgoingMessage =   createOutgoingMessage(incomingMessage, messageFlowTracker);
                messageFlowTracker.setOutgoingMessage(outgoingMessage);
            }

        }
    }

    private OutgoingMessage createOutgoingMessage(IncomingMessage IncomingMessage, MessageFlowTracker messageFlowTracker) {

        OutgoingMessage outgoingMessage = new OutgoingMessage();

        outgoingMessage.setLegType(messageFlowTracker.getLegType());
        outgoingMessage.setOutgoingMessage(IncomingMessage.getMessage() + "    : OUT=== ");
        outgoingMessage.setMessageFlowTracker(messageFlowTracker);
        return outgoingMessage;
    }

}
