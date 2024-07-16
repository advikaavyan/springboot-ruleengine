package com.example.poc.flow.model.context;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Navhold {

    LocalDateTime startTime;
    LocalDateTime releaseTime;

}
