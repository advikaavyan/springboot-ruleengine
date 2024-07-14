package com.example.flow.model.base.impl;

import com.example.flow.model.base.BaseContext;
import com.example.flow.model.base.TransactionKey;
import com.example.flow.model.base.TransactionCollection;
import lombok.Builder;

import java.util.HashMap;
import java.util.Map;

@Builder
public class StpContext implements BaseContext {
    private final Map<TransactionKey, TransactionCollection> transactionCollectionMap = new HashMap<>();
    private TransactionKey runningTransactionKey = TransactionKey.NONE;

    @Override
    public Map<TransactionKey, TransactionCollection> getTransactionMap() {
        return transactionCollectionMap;
    }



    @Override
    public TransactionCollection getTransactions(TransactionKey transactionKey) {
        if (transactionCollectionMap.size() == 0) {
            return null;
        } else {
            return transactionCollectionMap.get(transactionKey);
        }

    }

    @Override
    public Map<TransactionKey, TransactionCollection> addTransactions(TransactionKey transactionKey, TransactionCollection transactionCollection) {
        if (transactionCollectionMap.size() == 0) {
            runningTransactionKey = transactionKey;
            transactionCollectionMap.put(transactionKey, transactionCollection);
        }

        return transactionCollectionMap;
    }

    @Override
    public TransactionKey getRunningTransactionKey() {
        return runningTransactionKey;
    }
}
