package com.example.advikaavyan.adaptor.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "INCOMING_MESSAGE")
@Data
public class IncomingMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MESSAGE_ID")
    private Long messageId;

    @Column(name = "SOURCE", nullable = false)
    private String source;

    @Column(name = "MESSAGE", nullable = false, columnDefinition = "TEXT")
    private String message;

    @Column(name = "RECEIVED_AT", nullable = false, updatable = false, insertable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime receivedAt;

    @OneToMany(mappedBy = "incomingMessage", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OutgoingMessage> outgoingMessages = new ArrayList<>();

}
