package com.example.advikaavyan.adaptor.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "OUTGOING_MESSAGE")
@Data
public class OutgoingMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MESSAGE_ID")
    private Long messageId;
    @Column(name = "MESSAGE_TYPE", nullable = false)
    private String messageType;
    @Column(name = "MESSAGE", nullable = false, columnDefinition = "TEXT")
    private String message;
    @Column(name = "CREATED_AT", nullable = false, updatable = false, insertable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INCOMING_MESSAGE_ID", nullable = false)
    private IncomingMessage incomingMessage;

}