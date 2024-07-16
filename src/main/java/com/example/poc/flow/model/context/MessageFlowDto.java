package com.example.poc.flow.model.context;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageFlowDto {

    private String legType;

    private String status = "UNDEFINED";

    private String subStatus = "UNDEFINED";

    private LocalDateTime scheduleReleaseAt;
}
