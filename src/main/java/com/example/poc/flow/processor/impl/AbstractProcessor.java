package com.example.poc.flow.processor.impl;


import com.example.poc.flow.model.base.BaseContext;
import com.example.poc.flow.model.base.Transaction;
import com.example.poc.flow.model.base.TransactionKey;
import com.example.poc.flow.processor.AdaptorProcessor;

public abstract class AbstractProcessor implements AdaptorProcessor {


    public Transaction getLatestTransaction(BaseContext baseContext) {
        if (TransactionKey.NONE != baseContext.getRunningTransactionKey()) {
            return (Transaction) baseContext.getTransactions(baseContext.getRunningTransactionKey()).getLatestTransaction();
        }
        return null;
    }


}
