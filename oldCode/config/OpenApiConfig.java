package com.example.advikaavyan.adaptor.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Adaptor App API", version = "v1", description = "Adaptor App exposes the APIs to post the messages to transform, generate additional messages and persist into database." ))
public class OpenApiConfig {
}
