package com.example.poc.flow.model.context;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
@Data
public class MessageDataDto {

    private String rawMessage;
    private ZonedDateTime date;
    private String accountNumber;
    private String messageFunction;
    private String messageType;
    private double amount;
    private String currency;
    private int version;
    private String transactionId;


}
