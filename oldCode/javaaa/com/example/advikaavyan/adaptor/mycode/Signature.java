package com.example.advikaavyan.adaptor.mycode;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "SIGNATURE")
@Data
public class Signature {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "signature_seq")
    @SequenceGenerator(name = "signature_seq", sequenceName = "signature_seq", allocationSize = 1)
    private Long signatureId;

    @ManyToOne
    @JoinColumn(name = "MESSAGE_ID", nullable = false)
    private IncomingMessage incomingMessage;

    @Column(nullable = false)
    private String key;

    @Column(nullable = false)
    private String value;

    @Column(name = "CREATED_AT", nullable = false, updatable = false, insertable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    // Getters and Setters
}
