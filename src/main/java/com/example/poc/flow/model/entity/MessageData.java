package com.example.poc.flow.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "MESSAGE_DATA")
@Data
public class MessageData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MESSAGE_DATA_ID")
    private Long messageDataId;

    @ManyToOne
    @JoinColumn(name = "MESSAGE_ID", nullable = false)
    private InboundMessage inboundMessage;
    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;
    @Column(name = "TRADE_DATE")
    private LocalDate tradeDate;
    @Column(name = "SENDER_BIC")
    private String senderBic;


}
