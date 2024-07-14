package com.example.flow.model.base;

import java.util.Map;

public interface BaseContext<T> {
    Map<TransactionKey, TransactionCollection<T>> getTransactionMap();

    TransactionCollection<T> getTransactions(TransactionKey transactionKey);
    Map<TransactionKey, TransactionCollection<T>> addTransactions(TransactionKey transactionKey, TransactionCollection<T> tTransactionCollection);

    TransactionKey getRunningTransactionKey();

}
