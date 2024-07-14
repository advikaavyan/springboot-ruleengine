package com.example.flow.model.base;

public enum TransactionKey {

    A("A"),
    B("B"),
    C("C"),

    NONE("NONE");

    private String key;

    TransactionKey(String key) {
        this.key = key;
    }
}
