package com.example.advikaavyan.adaptor.mycode;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
@Slf4j
public class IncomingMessageController {

    private final MessageProcessingService messageProcessingService;

    @Autowired
    public IncomingMessageController(MessageProcessingService messageProcessingService) {
        this.messageProcessingService = messageProcessingService;
    }

    @PostMapping
    public ResponseEntity<IncomingMessage> processIncomingMessage(@RequestBody IncomingMessage incomingMessage) {
        IncomingMessage processedMessage = null;//messageProcessingService.processIncomingMessage(incomingMessage);
        return ResponseEntity.ok(processedMessage);
    }

    @GetMapping("/{data}")
    public ResponseEntity<String> saveIncomingMessage(@PathVariable String data) {
        log.info("Request received: message = {}", data);

        String processedMessage = messageProcessingService.processIncomingMessage(data);
        return ResponseEntity.ok(processedMessage);
    }
}
