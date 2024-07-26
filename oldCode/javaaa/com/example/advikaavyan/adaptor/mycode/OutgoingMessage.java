package com.example.advikaavyan.adaptor.mycode;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "OUTGOING_MESSAGE")
@Data
public class OutgoingMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "outgoing_message_seq")
    @SequenceGenerator(name = "outgoing_message_seq", sequenceName = "outgoing_message_seq", allocationSize = 1)
    private Long outgoingMessageId;

    @ManyToOne
    @JoinColumn(name = "MESSAGE_FLOW_TRACKER_ID", nullable = false)
    private MessageFlowTracker messageFlowTracker;

    @Column(nullable = false)
    private String legType;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private String outgoingMessage;

    // Getters and Setters
}
