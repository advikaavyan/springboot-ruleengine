package com.example.poc.flow.model.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "INBOUND_MESSAGE")
@Data
public class InboundMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MESSAGE_ID")
    private Long messageId;

    @Column(name = "SOURCE")
    private String source;

    @Lob
    @Column(name = "IN_MESSAGE")
    private String inMessage;

    @Column(name = "RECEIVED_AT")
    private LocalDateTime receivedAt;


}
