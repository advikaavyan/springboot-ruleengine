package com.example.advikaavyan.adaptor.mycode;

import com.example.advikaavyan.adaptor.dto.MessageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class IncomingMessageService {

    private final IncomingMessageRepository incomingMessageRepository;
    private final SignatureRepository signatureRepository;
    private final MessageFlowTrackerRepository messageFlowTrackerRepository;
    private final OutgoingMessageRepository outgoingMessageRepository;

    @Autowired
    public IncomingMessageService(IncomingMessageRepository incomingMessageRepository,
                                  SignatureRepository signatureRepository,
                                  MessageFlowTrackerRepository messageFlowTrackerRepository,
                                  OutgoingMessageRepository outgoingMessageRepository) {
        this.incomingMessageRepository = incomingMessageRepository;
        this.signatureRepository = signatureRepository;
        this.messageFlowTrackerRepository = messageFlowTrackerRepository;
        this.outgoingMessageRepository = outgoingMessageRepository;
    }

    String DUPE_KEY = "DUPE_KEY";
    @Transactional
    public String processIncomingMessage(MessageData messageData ) {
        // Check for existing messages based on the signature
        try {
            IncomingMessage incomingMessage = new IncomingMessage();
            incomingMessage.setMessage(messageData.getMessage());
            incomingMessage.setSource("SERV");
            incomingMessage.setMessageIdentifier("TMS001");
            incomingMessage.setReceivedAt(LocalDateTime.now());
            incomingMessage.setSignatures(createSignature(messageData));
            List<Signature> existingSignatures = signatureRepository.findByKeyAndValue(
                    DUPE_KEY,
                    messageData.getUuid()
            );
       /* List<Signature> existingSignatures = signatureRepository.findByKeyAndValue(
                incomingMessage.getSignatures().get(0).getKey(),
                incomingMessage.getSignatures().get(0).getValue()
        );*/

            if (!existingSignatures.isEmpty()) {
                // Update existing message context
                IncomingMessage existingMessage = existingSignatures.get(0).getIncomingMessage();
                updateMessageContext(existingMessage, incomingMessage);
                incomingMessageRepository.save(existingMessage);
                return "FFFFFFFFFFFF";
            } else {
                // Save new incoming message
                IncomingMessage savedMessage = incomingMessageRepository.save(incomingMessage);

                // Save associated signatures
                /*for (Signature signature : incomingMessage.getSignatures()) {
                    signature.setIncomingMessage(savedMessage);
                    signatureRepository.save(signature);
                }*/

                // Perform business logic to create trackers and outgoing messages
                createAndSaveTrackersAndOutgoingMessages(savedMessage);

                return "AAAAAAAAAAAAAAAAA";
            }
        }catch(RuntimeException exception){
            System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAa");
        }
        return "AAAAAAAAAAAAAAASDDDDDDDDDDDDDDDDD";
    }
    private List<Signature> createSignature(MessageData messageData ) {

        List<Signature> signatures = new ArrayList<>();
        Signature signature1 = new Signature();
        signature1.setKey(DUPE_KEY);
        signature1.setValue(messageData.getUuid());
        signatures.add(signature1);

        return signatures;
    }
    private void updateMessageContext(IncomingMessage existingMessage, IncomingMessage newMessage) {
        // Implement your logic to update the existing message context with the new message data
        // This could involve updating fields, merging data, etc.
    }

    private void createAndSaveTrackersAndOutgoingMessages(IncomingMessage savedMessage) {
        // Implement your logic to create trackers and outgoing messages based on the saved message
        // For example:

        // Create and save a new tracker
        MessageFlowTracker tracker = new MessageFlowTracker();
        tracker.setIncomingMessage(savedMessage);
        tracker.setLegType("exampleLegType");
        tracker.setStatus("exampleStatus");
        tracker.setSubStatus("exampleSubStatus");
        tracker.setCreatedAt(LocalDateTime.now());
        tracker.setInFlight(false);
       // messageFlowTrackerRepository.save(tracker);

        // Create and save a new outgoing message
        OutgoingMessage outgoingMessage = new OutgoingMessage();
        outgoingMessage.setMessageFlowTracker(tracker);
        outgoingMessage.setLegType("exampleLegType");
        outgoingMessage.setCreatedAt(LocalDateTime.now());
        outgoingMessage.setOutgoingMessage("exampleOutgoingMessage");

       // outgoingMessageRepository.save(outgoingMessage);
    }
}
