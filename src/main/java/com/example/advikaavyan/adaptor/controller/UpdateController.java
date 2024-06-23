package com.example.advikaavyan.adaptor.controller;

import com.example.advikaavyan.adaptor.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/update")
public class UpdateController {

    @Autowired
    private MessageService messageService;


    @GetMapping("/{id}")
    public ResponseEntity<String> updateAAAAA(@PathVariable Long id) {
        messageService.updateRecord(id);
        return ResponseEntity.ok("Status updated successfully");
    }
}
