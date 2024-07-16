package com.example.poc.flow.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "OUTBOUND_MESSAGE")
@Data
public class OutboundMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OUTBOUND_MESSAGE_ID")
    private Long outboundMessageId;

    @ManyToOne
    @JoinColumn(name = "MESSAGE_FLOW_TRACKER_ID", nullable = false)
    private MessageFlowTracker messageFlowTracker;
    @Column(name = "LEG_TYPE")
    private String legType;

    @Lob
    @Column(name = "OUT_MESSAGE")
    private String outMessage;
    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;


}
