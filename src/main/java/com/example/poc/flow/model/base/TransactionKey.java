package com.example.poc.flow.model.base;

public enum TransactionKey {

    NEWM("NEWM"),
    CANC("CANC"),
    NONE("NONE");

    private String key;

    TransactionKey(String key) {
        this.key = key;
    }
}
