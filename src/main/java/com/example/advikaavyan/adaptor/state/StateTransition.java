package com.example.advikaavyan.adaptor.state;

import java.util.Arrays;
import java.util.List;

public class StateTransition {

    private final List<TransactionTransition> STP_TRANSITIONS = Arrays.asList(new UndefinedToSentTransition());
    private final List<TransactionTransition> RELEASE_TRANSITIONS = Arrays.asList(new UndefinedToSentTransition());
    private final List<TransactionTransition> ACKNACK_TRANSITIONS = Arrays.asList(new UndefinedToSentTransition());

    public void applyStpTransitions(Transaction transaction) {
        System.out.println("applyStpTransitions: ");
        TransactionTransitionManager transitionManager = new TransactionTransitionManager(STP_TRANSITIONS);
        System.out.println("Before transition: " + transaction);
        transitionManager.applyTransition(transaction);
        System.out.println("After transition: " + transaction);
    }

    public void applyReleaseTransitions(Transaction transaction) {
        System.out.println("applyReleaseTransitions: ");
        TransactionTransitionManager transitionManager = new TransactionTransitionManager(RELEASE_TRANSITIONS);
        System.out.println("Before transition: " + transaction);
        transitionManager.applyTransition(transaction);
        System.out.println("After transition: " + transaction);
    }

    public void applyAckNackTransitions(Transaction transaction) {
        System.out.println("applyReleaseTransitions: ");
        TransactionTransitionManager transitionManager = new TransactionTransitionManager(ACKNACK_TRANSITIONS);
        System.out.println("Before transition: " + transaction);
        transitionManager.applyTransition(transaction);
        System.out.println("After transition: " + transaction);
    }
}
