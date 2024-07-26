package com.example.advikaavyan.adaptor.state;

public class UndefinedToSentTransition implements TransactionTransition {

    @Override
    public boolean isApplicable(Transaction transaction) {
        return transaction.getStatus() == Status.UNDEFINED &&
                transaction.getSubStatus() == SubStatus.UNDEFINED &&
                "Y".equals(transaction.getOnHold());
    }

    @Override
    public void apply(Transaction transaction) {
        transaction.setStatus(Status.SENT);
        transaction.setSubStatus(SubStatus.READY_TO_SEND);
    }
}

