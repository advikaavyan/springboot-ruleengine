package com.example.advikaavyan.adaptor.dto.controller;


import com.example.advikaavyan.adaptor.dto.InMessage;
import com.example.advikaavyan.adaptor.dto.InMessageResponse;
import com.example.advikaavyan.adaptor.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
@Slf4j
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    /*  @PostMapping("/incoming")
      public IncomingMessage saveIncomingMessage(@RequestBody IncomingMessage incomingMessage) {
          return messageService.saveIncomingAndOutgoingMessages(incomingMessage);
      }*/
    @GetMapping("/incoming/{data}")
    public InMessageResponse saveIncomingMessage(@PathVariable String data) {
        log.info("Request received: message = {}", data);
        InMessage inMessage = InMessage.builder().source("REST_API").message(data).build();
        return messageService.saveIncomingAndOutgoingMessages(inMessage);
    }

}
