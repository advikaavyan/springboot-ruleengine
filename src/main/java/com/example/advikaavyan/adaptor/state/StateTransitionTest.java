package com.example.advikaavyan.adaptor.state;

public class StateTransitionTest {
    public static void maina(String[] args) {
        Transaction transaction = new Transaction(Status.UNDEFINED, SubStatus.UNDEFINED, "Y");
        StateTransition stateTransition = new StateTransition();
        stateTransition.applyStpTransitions(transaction);
        stateTransition.applyAckNackTransitions(transaction);
        stateTransition.applyReleaseTransitions(transaction);
    }


}
