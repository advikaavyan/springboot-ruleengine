package com.example.poc.flow.processor.impl;


import com.example.poc.flow.model.base.BaseContext;
import com.example.poc.flow.model.base.Transaction;
import com.example.poc.flow.model.base.TransactionKey;
import com.example.poc.flow.processor.AdaptorProcessor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractProcessor implements AdaptorProcessor {
    @Override
    public BaseContext execute(final BaseContext baseContext) {
        log.warn("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ Inside " + getCaller().getClassName().substring(getCaller().getClassName().lastIndexOf('.') + 1));
        return baseContext;
    }

    public Transaction getLatestTransaction(BaseContext baseContext) {
        if (TransactionKey.NONE != baseContext.getRunningTransactionKey()) {
            return (Transaction) baseContext.getTransactions(baseContext.getRunningTransactionKey()).getLatestTransaction();
        }
        return null;
    }

    public StackTraceElement getCaller() {
        // Get the stack trace
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        // The element at index 2 will be the caller of this method
        // Index 0 is getStackTrace(), index 1 is this method, and index 2 is the caller
        StackTraceElement caller = stackTrace[3];

        // Log the caller class name
        return caller;
    }


}
