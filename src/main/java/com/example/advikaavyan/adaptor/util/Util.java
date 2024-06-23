package com.example.advikaavyan.adaptor.util;

import com.example.advikaavyan.adaptor.entity.IncomingMessage;
import com.example.advikaavyan.adaptor.entity.MessageFlowTracker;
import com.example.advikaavyan.adaptor.entity.OutgoingMessage;
import com.example.advikaavyan.adaptor.entity.Signature;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Util {

    public static List<Signature> createSign(IncomingMessage incomingMessage) {
        List<Signature> signatures = new ArrayList<>();
        for (int i = 1; i < 5; i++) {

            Signature signature = new Signature();
            signature.setSignatureKey("DUPE KEY " + i);
            signature.setSignatureValue("VALUE " + i);
            signatures.add(signature);


        }
        return signatures;
    }

    private List<MessageFlowTracker> createMessageFlowTracker(IncomingMessage incomingMessage) {
        List<MessageFlowTracker>  signatures = new ArrayList<>();
        for (int i = 1; i < 5; i++) {

            MessageFlowTracker signature = new MessageFlowTracker();

            signature.setLegType("TRADE");
            signature.setStatus("ON_HOLD " + i);
            signature.setSubStatus("SENT" +i);
            // when below was not added throwing org.hibernate.PropertyValueException: not-null property references a null or transient value : com.example.advikaavyan.adaptor.entity.MessageFlowTracker.incomingMessage
            signature.setIncomingMessage(incomingMessage);
            signatures.add(signature);
        }
        return signatures;
    }
    private void createOutgoingMessages(IncomingMessage  IncomingMessage, MessageFlowTracker messageFlowTracker) {
        Set<OutgoingMessage> signatures = new HashSet<>();
        OutgoingMessage signature = new OutgoingMessage();

        signature.setLegType(messageFlowTracker.getLegType());
        signature.setOutgoingMessage(IncomingMessage.getMessage() +"    : OUT=== " );
        signature.setMessageFlowTracker(messageFlowTracker);
        signatures.add(signature);
    }

}
