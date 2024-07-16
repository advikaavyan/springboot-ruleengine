package com.example.poc.flow.model.context;

import lombok.Data;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

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
    private String source;

    private List<String> legs = new ArrayList<>();


}
