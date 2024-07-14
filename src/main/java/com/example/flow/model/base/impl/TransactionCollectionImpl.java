package com.example.flow.model.base.impl;

import com.example.flow.model.base.TransactionCollection;

import java.util.ArrayList;
import java.util.List;

public class TransactionCollectionImpl<T> implements TransactionCollection<T> {
    private final List<T> transactions;

    public TransactionCollectionImpl() {
        this.transactions = new ArrayList<>();
    }

    @Override
    public T getLatestTransaction() {
        if (transactions.isEmpty()) {
            return null;
        }
        return transactions.get(transactions.size() - 1);
    }

    @Override
    public T appendTransaction(T t) {
        transactions.add(t);
        return t;
    }

    @Override
    public int size() {
        return transactions.size();
    }
/*
    public static void main(String[] args) {
        TransactionCollectionImpl<String> transactionCollection = new TransactionCollectionImpl<>();
        transactionCollection.appendTransaction("Transaction1");
        transactionCollection.appendTransaction("Transaction2");

        System.out.println("Latest Transaction: " + transactionCollection.getLatestTransaction());
        System.out.println("Total Transactions: " + transactionCollection.size());
    }*/
}
