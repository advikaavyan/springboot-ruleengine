package com.example.poc.flow.ser;

import com.example.poc.flow.mapper.InboundMessageMapper;
import com.example.poc.flow.model.base.BaseContext;
import com.example.poc.flow.model.base.Transaction;
import com.example.poc.flow.model.base.TransactionKey;
import com.example.poc.flow.model.entity.InboundMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PersistService {
    private final InboundMessageDaoService inboundMessageDaoService;
    private final MessageDataDaoService messageDataDaoService;
    private final MatchingSignatureDaoService matchingSignatureDaoService;
    private final MessageFlowTrackerDaoService messageFlowTrackerDaoService;
    private final OutboundMessageDaoService outboundMessageDaoService;

    private final InboundMessageMapper inboundMessageMapper;

    public PersistService(InboundMessageDaoService inboundMessageDaoService, MessageDataDaoService messageDataDaoService,
                          MatchingSignatureDaoService matchingSignatureDaoService,
                          MessageFlowTrackerDaoService messageFlowTrackerDaoService, OutboundMessageDaoService outboundMessageDaoService, InboundMessageMapper inboundMessageMapper) {
        this.inboundMessageDaoService = inboundMessageDaoService;
        this.messageDataDaoService = messageDataDaoService;
        this.matchingSignatureDaoService = matchingSignatureDaoService;
        this.messageFlowTrackerDaoService = messageFlowTrackerDaoService;
        this.outboundMessageDaoService = outboundMessageDaoService;
        this.inboundMessageMapper = inboundMessageMapper;
    }

    public void persist(BaseContext baseContext){
        InboundMessage inboundMessage = inboundMessageMapper.toEntity(getLatestTransaction(baseContext).getMessageData());
        inboundMessageDaoService.save(inboundMessage);
        log.info("Going to save...........");
    }
    public Transaction getLatestTransaction(BaseContext baseContext) {
        if (TransactionKey.NONE != baseContext.getRunningTransactionKey()) {
            return (Transaction) baseContext.getTransactions(baseContext.getRunningTransactionKey()).getLatestTransaction();
        }
        return null;
    }

}
