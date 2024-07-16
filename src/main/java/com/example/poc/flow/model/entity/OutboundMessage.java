package com.example.poc.flow.model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "OUTBOUND_MESSAGE")
public class OutboundMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long outboundMessageId;

    @ManyToOne
    @JoinColumn(name = "MESSAGE_FLOW_TRACKER_ID", nullable = false)
    private MessageFlowTracker messageFlowTracker;

    private String legType;

    @Lob
    private String outMessage;

    private LocalDateTime createdAt;

    // Getters and Setters
}
