package com.example.advikaavyan.adaptor.api;

import com.example.advikaavyan.adaptor.dto.AdaptorApiResponse;
import com.example.advikaavyan.adaptor.dto.MessageDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

public interface MessageApi {

    @Operation(summary = "Create a new Message")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Message created successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class),

                            examples = @ExampleObject(
                                    value = "{\n" +
                                            "  \"messageIdentifier\": \"12345\",\n" +
                                            "  \"source\": \"SystemA\",\n" +
                                            "  \"receivedAt\": \"2023-06-23T12:34:56.789Z\",\n" +
                                            "  \"message\": \"This is a sample message\" \n" +
                                            "}"
                            ))}),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    ResponseEntity<AdaptorApiResponse> createMessage(String messageDTO);
}

