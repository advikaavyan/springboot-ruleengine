package com.example.advikaavyan.adaptor.state;

import lombok.Data;

@Data
public class Transaction {
    private Status status;
    private SubStatus subStatus;
    private String onHold;

    public Transaction(Status status, SubStatus subStatus, String onHold) {
        this.status = status;
        this.subStatus = subStatus;
        this.onHold = onHold;
    }

}
