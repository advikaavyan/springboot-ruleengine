package com.example.advikaavyan.adaptor.controller;

import com.example.advikaavyan.adaptor.api.MessageApi;
import com.example.advikaavyan.adaptor.model.dto.AdaptorApiResponse;
import com.example.advikaavyan.adaptor.model.dto.MessageDTO;
import com.example.advikaavyan.adaptor.entity.IncomingMessage;
import com.example.advikaavyan.adaptor.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/messages")

public class MessageController implements MessageApi {

    @Autowired
    private MessageService messageService;

    @Override
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<AdaptorApiResponse> createMessage(@RequestBody String message) {

        IncomingMessage incomingMessage = messageService.processMessage(createMessageDTO(message));

        log.info("createMessage....................");
        //AdaptorApiResponse<String> response = new AdaptorApiResponse<>(201, "Message created successfully", "Message Id: " + incomingMessage.getMessageId());
        AdaptorApiResponse<IncomingMessage> response = new AdaptorApiResponse<>(201, "Message created successfully", incomingMessage);
        log.info("createMessage Created...................");
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    private MessageDTO createMessageDTO(String rawMessage) {
        return MessageDTO.builder().message(rawMessage).source("GOOGLE").messageIdentifier("TMS00001").build();

    }

   /* @PostMapping
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
    }*/


}
