package com.example.poc.flow.model.base;

import java.util.Map;
import java.util.Set;

public interface BaseContext<T> {
    Map<TransactionKey, TransactionCollection<T>> getTransactionMap();

    TransactionCollection<T> getTransactions(TransactionKey transactionKey);

    Set<TransactionKey> getTransactionKeys();

    Map<TransactionKey, TransactionCollection<T>> addTransactions(TransactionKey transactionKey, TransactionCollection<T> tTransactionCollection);

    TransactionKey getRunningTransactionKey();

}
