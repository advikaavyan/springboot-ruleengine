package com.example.poc.flow.model.dto;

import java.time.LocalDateTime;

public class MessageFlowTrackerDTO {
    private Long messageFlowTrackerId;
    private Long messageId;
    private String legType;
    private String status;
    private String subStatus;
    private LocalDateTime scheduleReleaseAt;
    private LocalDateTime createdAt;
    private Boolean inFlight;
    private LocalDateTime inFlightExpiredAt;

    // Getters and Setters
}
