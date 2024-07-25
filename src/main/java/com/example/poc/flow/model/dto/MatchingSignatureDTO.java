package com.example.poc.flow.model.dto;

import com.example.poc.flow.model.base.MatchingKey;
import lombok.Data;

@Data
public class MatchingSignatureDTO {
    private Long matchingSignatureId;
    private Long messageId;
    private MatchingKey matchingKey;
    private String matchingValue;
    private Boolean isValid;

    // Getters and Setters
}
