package com.example.poc.flow.model.dto;

import lombok.Data;

@Data
public class MatchingSignatureDTO {
    private Long matchingSignatureId;
    private Long messageId;
    private String matchingKey;
    private String matchingValue;
    private Boolean isValid;

    // Getters and Setters
}
