package com.example.advikaavyan.adaptor.state;

import java.util.List;

public class TransactionTransitionManager {

    private final List<TransactionTransition> transitions;

    public TransactionTransitionManager(List<TransactionTransition> transitions) {
        this.transitions = transitions;
    }

    public void applyTransition(Transaction transaction) {
        for (TransactionTransition transition : transitions) {
            if (transition.isApplicable(transaction)) {
                transition.apply(transaction);
                break; // Apply only the first applicable transition
            }
        }
    }
}
