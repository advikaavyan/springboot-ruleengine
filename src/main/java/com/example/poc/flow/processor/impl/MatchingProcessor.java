package com.example.poc.flow.processor.impl;


import com.example.poc.flow.model.base.BaseContext;
import com.example.poc.flow.model.base.Transaction;
import com.example.poc.flow.model.base.TransactionKey;
import com.example.poc.flow.model.context.MessageDataDto;
import com.example.poc.flow.model.context.SignatureDto;
import com.example.poc.flow.processor.AdaptorProcessor;
import com.example.poc.flow.ser.MatchingService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MatchingProcessor implements AdaptorProcessor {

    private final MatchingService matchingService;

    public MatchingProcessor(MatchingService matchingService) {
        this.matchingService = matchingService;
    }

    @Override
    public BaseContext execute(final BaseContext baseContext) {
        if (TransactionKey.NONE != baseContext.getRunningTransactionKey()) {
            Transaction transaction = (Transaction) baseContext.getTransactions(baseContext.getRunningTransactionKey()).getLatestTransaction();
            if (!getMatchingSignatures(transaction).isEmpty()) {
                // throw exceptions
            }
        }
        return baseContext;
    }

    private List<SignatureDto> getMatchingSignatures(Transaction transaction) {
        MessageDataDto messageDataDto = transaction.getMessageData();
        List<SignatureDto> signatureDtos = matchingService.matches(messageDataDto);
        // db call to get list of Signatures and convert into DTO
        return List.of();
    }

    private List<SignatureDto> createMatchingKey(Transaction transaction) {
        MessageDataDto messageDataDto = transaction.getMessageData();
        List<SignatureDto> signatureDtos = matchingService.matches(messageDataDto);
        // db call to get list of Signatures and convert into DTO
        return List.of();
    }


}
