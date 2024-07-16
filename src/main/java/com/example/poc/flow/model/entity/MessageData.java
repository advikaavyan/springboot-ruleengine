package com.example.poc.flow.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "MESSAGE_DATA")
public class MessageData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageDataId;

    @ManyToOne
    @JoinColumn(name = "MESSAGE_ID", nullable = false)
    private InboundMessage inboundMessage;

    private String accountNumber;

    private LocalDate tradeDate;

    private String senderBic;

    // Getters and Setters
}
