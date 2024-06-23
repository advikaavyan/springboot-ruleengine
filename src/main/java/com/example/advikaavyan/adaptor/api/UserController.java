package com.example.advikaavyan.adaptor.api;

import com.example.advikaavyan.adaptor.dto.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController implements UserApi {

    @Override
    @PostMapping(consumes = "application/xml", produces = "application/xml")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // Logic to handle the user creation
        User user1 = new User();
        return ResponseEntity.ok(user);
    }
}