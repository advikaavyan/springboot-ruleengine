package com.example.poc.flow.model.entity;

import com.example.poc.flow.model.base.MatchingKey;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "MATCHING_SIGNATURE")
@Data
public class MatchingSignature {
/*
    private final String FORMAT = "%-20s %-10s %-30s%n", "Name", "Age", "Email"*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "MATCHING_SIGNATURE_ID")
    private Long matchingSignatureId;

    @ManyToOne
    @JoinColumn(name = "MESSAGE_ID", nullable = false)
    private InboundMessage inboundMessage;

    @Column(name = "MATCHING_KEY")
    @Enumerated(EnumType.STRING)
    private MatchingKey matchingKey;

    @Lob
    @Column(name = "MATCHING_VALUE")
    private String matchingValue;


    @Column(name = "IS_VALID")
    private Boolean isValid;

    // Getters and Setters
}
