package com.example.flow.model.base;

public interface TransactionCollection<T> {

    T getLatestTransaction();

    T appendTransaction(T t);

    int size();

}
