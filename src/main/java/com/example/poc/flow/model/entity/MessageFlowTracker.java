package com.example.poc.flow.model.entity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "MESSAGE_FLOW_TRACKER")
public class MessageFlowTracker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageFlowTrackerId;

    @ManyToOne
    @JoinColumn(name = "MESSAGE_ID", nullable = false)
    private InboundMessage inboundMessage;

    private String legType;

    private String status;

    private String subStatus;

    private LocalDateTime scheduleReleaseAt;

    private LocalDateTime createdAt;

    private Boolean inFlight;

    private LocalDateTime inFlightExpiredAt;

    // Getters and Setters
}
