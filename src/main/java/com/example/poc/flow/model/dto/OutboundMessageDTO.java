package com.example.poc.flow.model.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class OutboundMessageDTO {
    private Long outboundMessageId;
    private Long messageFlowTrackerId;
    private String legType;
    private String outMessage;
    private LocalDateTime createdAt;

    // Getters and Setters
}
