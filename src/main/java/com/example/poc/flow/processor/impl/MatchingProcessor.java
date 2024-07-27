package com.example.poc.flow.processor.impl;


import com.example.poc.flow.helper.TransactionMapper;
import com.example.poc.flow.model.base.*;
import com.example.poc.flow.model.base.impl.TransactionCollectionImpl;
import com.example.poc.flow.model.dto.MatchingSignatureDTO;
import com.example.poc.flow.model.entity.InboundMessage;
import com.example.poc.flow.model.entity.MatchingSignature;
import com.example.poc.flow.ser.InboundMessageDaoService;
import com.example.poc.flow.ser.MatchingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
@Slf4j
@RequiredArgsConstructor
public class MatchingProcessor extends AbstractProcessor {

    private final MatchingService matchingService;
    private final InboundMessageDaoService inboundMessageDaoService;
    @Autowired
    TransactionMapper entityToDTOs;


    @Override
    public BaseContext execute(BaseContext baseContext) {
        super.execute(baseContext);
        Transaction transaction = getLatestTransaction(baseContext);
        List<MatchingSignatureDTO> matchingSignatureDTOS = matchingService.createMatchingKeys(transaction);
        transaction.getMatchingSignatures().addAll(matchingSignatureDTOS);

        if (Objects.nonNull(getLatestTransaction(baseContext))) {
            List<MatchingSignature> matchingSignatures = matchingService.getMatchingSignatures(matchingSignatureDTOS);
            if (matchingSignatures.isEmpty()) {
                log.info("NO MatchingSignatures found for its own message type, now going to check linked message functions key to load its data to update into current context ....");
                List<MatchingSignatureDTO> linkedMatchingSignatureDTOS = matchingService.createLinkedMatchingKeys(transaction);
                List<MatchingSignature> linkedMatchingSignatures = matchingService.getMatchingSignatures(linkedMatchingSignatureDTOS);
                if (linkedMatchingSignatures.isEmpty()) {
                    log.info("NO Linked Message Function MatchingSignatures found add the message signatures into context and return the context .");
                    return baseContext;
                } else {
                    log.info("Linked Message Function MatchingSignatures found load linked message function data into current context along with received message functions signature .");
                    return mergeCurrentContextWithLinkedTransactionData(baseContext, linkedMatchingSignatures);
                }
            } else {

                if (matchingSignatures.size() == 1 && matchingSignatures.get(0).getMatchingKey() == MatchingKey.NEWM_BASKET) {
                    log.info("Only NEWM_BASKET Present, means Current Trade is Amend Trade.");
                    return mergeCurrentContextWithLinkedTransactionData11(baseContext, matchingSignatures);
                } else {
                    log.error("Duplicate Trades found, now going to throw exceptions..........................................");
                    throwException(matchingService.ListToMap(matchingSignatures));
                }
            }
        }
        return baseContext;
    }


    private void throwException(Map<MatchingKey, MatchingSignature> matchingSignatureMap) {
        MatchingSignature matchingSignature = matchingSignatureMap.get(MatchingKey.BME_HEADER_DUPE);
        if (Objects.nonNull(matchingSignature)) {
            throw new RuntimeException("Duplicate Message: BME_HEADER_DUPE Already Trade with uuid = " + matchingSignature.getMatchingValue() + " found with message Id " + matchingSignature.getInboundMessage().getMessageId());
        }
        matchingSignature = matchingSignatureMap.get(MatchingKey.NEWM_BASKET_VERSION_DUPE);
        if (Objects.nonNull(matchingSignature)) {
            throw new RuntimeException(("Duplicate Message: BASKET_VERSION_DUPE- NEWM Already Trade with same uuid, basket and version =" + matchingSignature.getMatchingValue() + " found with message Id  " + matchingSignature.getInboundMessage().getMessageId()));
        }
        matchingSignature = matchingSignatureMap.get(MatchingKey.CANC_BASKET_VERSION_DUPE);
        if (Objects.nonNull(matchingSignature)) {
            throw new RuntimeException(("Duplicate Message:  BASKET_VERSION_DUPE- CANC Already Trade with same uuid, basket and version =" + matchingSignature.getMatchingValue() + " found with message Id  " + matchingSignature.getInboundMessage().getMessageId()));
        }
    }

    private BaseContext mergeCurrentContextWithLinkedTransactionData11(BaseContext baseContext, List<MatchingSignature> linkedMatchingSignatures) {
        log.info("Before " + "-------------------" + baseContext.getTransactionKeys());

        for (MatchingSignature matchingSignature : linkedMatchingSignatures) {

            List<InboundMessage> inboundMessages = inboundMessageDaoService.findByMessageIdentifier(matchingSignature.getInboundMessage().getMessageIdentifier());
            String messageFunction = matchingSignature.getMatchingKey().toString().substring(0, matchingSignature.getMatchingKey().toString().indexOf("_BASKET"));
            Transaction transaction = entityToDTOs.toTransaction(matchingSignature);
            TransactionCollection transactionCollection = new TransactionCollectionImpl();
            transactionCollection.appendTransaction(transaction);
            baseContext.addTransactions(TransactionKey.valueOf(messageFunction), transactionCollection);
        }

        log.info("After " + "-------------------" + baseContext.getTransactionKeys());

        return baseContext;
    }

    private BaseContext mergeCurrentContextWithLinkedTransactionData(BaseContext baseContext, List<MatchingSignature> linkedMatchingSignatures) {
        log.info("Before " + "-------------------" + baseContext.getTransactionKeys());

        for (MatchingSignature matchingSignature : linkedMatchingSignatures) {


            String messageFunction = matchingSignature.getMatchingKey().toString().substring(0, matchingSignature.getMatchingKey().toString().indexOf("_BASKET"));
            Transaction transaction = entityToDTOs.toTransaction(matchingSignature);
            TransactionCollection transactionCollection = new TransactionCollectionImpl();
            transactionCollection.appendTransaction(transaction);
            baseContext.addTransactions(TransactionKey.valueOf(messageFunction), transactionCollection);
        }

        log.info("After " + "-------------------" + baseContext.getTransactionKeys());

        return baseContext;
    }


}
