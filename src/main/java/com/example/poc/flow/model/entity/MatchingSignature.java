package com.example.poc.flow.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "MATCHING_SIGNATURE")
public class MatchingSignature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "MATCHING_SIGNATURE_ID")
    private Long matchingSignatureId;

    @ManyToOne
    @JoinColumn(name = "MESSAGE_ID", nullable = false)
    private InboundMessage inboundMessage;

    @Column(name = "MATCHING_KEY")
    private String matchingKey;

    @Lob
    @Column(name = "MATCHING_VALUE")
    private String matchingValue;


    @Column(name = "IS_VALID")
    private Boolean isValid;

    // Getters and Setters
}
