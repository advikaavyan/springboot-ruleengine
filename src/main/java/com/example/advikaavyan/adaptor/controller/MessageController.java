package com.example.advikaavyan.adaptor.controller;

import com.example.advikaavyan.adaptor.dto.MessageDTO;
import com.example.advikaavyan.adaptor.service.MessageService;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.StringReader;

@RestController
@Slf4j
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping
    public ResponseEntity<String> receiveMessage(@RequestBody String xmlMessage) {
        try {
            JAXBContext context = JAXBContext.newInstance(MessageDTO.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            MessageDTO messageDTO = (MessageDTO) unmarshaller.unmarshal(new StringReader(xmlMessage));
            messageService.processMessage(messageDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Message processed successfully");
        } catch (JAXBException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid XML format");
        }
    }

    @PostMapping("/{id}/status")
    public ResponseEntity<String> updateStatus(@PathVariable Long id, @RequestParam String status) {
        messageService.updateRecord(id, status);
        return ResponseEntity.ok("Status updated successfully");
    }

    @GetMapping("/{data}")
    public ResponseEntity<String> saveIncomingMessage(@PathVariable String data) {
        log.info("Request received: message = {}", data);
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setMessage(data);
        messageDTO.setSource("TIM");
        messageService.processMessage(messageDTO);
        return ResponseEntity.ok("Status updated successfully");
    }


}
