package com.example.advikaavyan.adaptor.api;

import com.example.advikaavyan.adaptor.model.dto.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

public interface UserApi {

    @Operation(summary = "Create a new user")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "User created successfully",
            content = { @Content(mediaType = "application/xml",
            schema = @Schema(implementation = User.class),
            examples = @ExampleObject(
                value = "<user><id>1</id><name>John Doe</name><email>john.doe@example.com</email></user>"
            ))}),
        @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    ResponseEntity<User> createUser(User user);
}
