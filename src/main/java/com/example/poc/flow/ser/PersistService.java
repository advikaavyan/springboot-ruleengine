package com.example.poc.flow.ser;

import com.example.poc.flow.mapper.*;
import com.example.poc.flow.model.base.BaseContext;
import com.example.poc.flow.model.base.Transaction;
import com.example.poc.flow.model.base.TransactionKey;
import com.example.poc.flow.model.dto.MatchingSignatureDTO;
import com.example.poc.flow.model.dto.MessageFlowTrackerDTO;
import com.example.poc.flow.model.entity.InboundMessage;
import com.example.poc.flow.model.entity.MatchingSignature;
import com.example.poc.flow.model.entity.MessageFlowTracker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class PersistService {
    private final InboundMessageDaoService inboundMessageDaoService;
    private final MessageDataDaoService messageDataDaoService;
    private final MatchingSignatureDaoService matchingSignatureDaoService;
    private final MessageFlowTrackerDaoService messageFlowTrackerDaoService;
    private final OutboundMessageDaoService outboundMessageDaoService;

    private final InboundMessageMapper inboundMessageMapper;
    private final MessageDataMapper messageDataMapper;
    private final MatchingSignatureMapper matchingSignatureMapper;
    private final MessageFlowTrackerMapper messageFlowTrackerMapper;
    private final OutboundMessageMapper outboundMessageMapper;

    public PersistService(InboundMessageDaoService inboundMessageDaoService, MessageDataDaoService messageDataDaoService,
                          MatchingSignatureDaoService matchingSignatureDaoService,
                          MessageFlowTrackerDaoService messageFlowTrackerDaoService, OutboundMessageDaoService outboundMessageDaoService,
                          InboundMessageMapper inboundMessageMapper, MessageDataMapper messageDataMapper, MatchingSignatureMapper matchingSignatureMapper,
                          MessageFlowTrackerMapper messageFlowTrackerMapper, OutboundMessageMapper outboundMessageMapper) {

        this.inboundMessageDaoService = inboundMessageDaoService;
        this.messageDataDaoService = messageDataDaoService;
        this.matchingSignatureDaoService = matchingSignatureDaoService;
        this.messageFlowTrackerDaoService = messageFlowTrackerDaoService;
        this.outboundMessageDaoService = outboundMessageDaoService;
        this.inboundMessageMapper = inboundMessageMapper;
        this.messageDataMapper = messageDataMapper;
        this.matchingSignatureMapper = matchingSignatureMapper;
        this.messageFlowTrackerMapper = messageFlowTrackerMapper;
        this.outboundMessageMapper = outboundMessageMapper;
    }

    public void persist(BaseContext baseContext) {

        Transaction transaction = getLatestTransaction(baseContext);


        InboundMessage inboundMessage = inboundMessageMapper.toEntity(transaction.getMessageData());

        // MessageData messageData = messageDataMapper.toEntity(transaction.getMessageData(), inboundMessage);

        List<MatchingSignature> matchingSignatures = new ArrayList<>();
        for (MatchingSignatureDTO matchingSignatureDTO : transaction.getMatchingSignatures()) {
            matchingSignatures.add(matchingSignatureMapper.toEntity(matchingSignatureDTO, inboundMessage));
        }


        List<MessageFlowTracker> messageFlowTrackers = new ArrayList<>();
        for (MessageFlowTrackerDTO messageFlowTrackerDTO : transaction.getMessageFlows()) {
            messageFlowTrackers.add(messageFlowTrackerMapper.toEntity(messageFlowTrackerDTO, inboundMessage));
        }


      /*  List<OutboundMessage> outboundMessages = new ArrayList<>();
        for (OutboundMessageDTO outboundMessageDTO : transaction.getOutbounds()) {
            outboundMessages.add(outboundMessageMapper.toEntity(outboundMessageDTO, inboundMessage));
        }
*/
        inboundMessageDaoService.save(inboundMessage);
        //  messageDataDaoService.save(messageData);
        matchingSignatureDaoService.saveAll(matchingSignatures);

        List<MessageFlowTracker> messageFlowTrackers1 = messageFlowTrackerDaoService.saveAll(messageFlowTrackers);


        if (!transaction.getOutbounds().isEmpty()) {
            outboundMessageDaoService.saveOutboundMessages(messageFlowTrackers1, transaction.getOutbounds());
        }

        // log.info("Records saved...........");
    }

    public Transaction getLatestTransaction(BaseContext baseContext) {
        if (TransactionKey.NONE != baseContext.getRunningTransactionKey()) {
            return (Transaction) baseContext.getTransactions(baseContext.getRunningTransactionKey()).getLatestTransaction();
        }
        return null;
    }

}
