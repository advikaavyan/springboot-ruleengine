package com.example.poc.flow.model.dto;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class MessageDataDTO {
    private String rawMessage;
    private ZonedDateTime date;
    private String accountNumber;
    private String messageFunction;
    private String messageType;
    private double amount;
    private String currency;
    private int version;
    private String transactionId;
    private String source;
    private String uuid;
    private List<String> legs = new ArrayList<>();

    // Getters and Setters
}
