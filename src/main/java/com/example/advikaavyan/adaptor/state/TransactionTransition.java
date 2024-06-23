package com.example.advikaavyan.adaptor.state;

public interface TransactionTransition {
    boolean isApplicable(Transaction transaction);
    void apply(Transaction transaction);
}
