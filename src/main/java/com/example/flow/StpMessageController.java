package com.example.flow;

import com.example.flow.impl.STPFlow;
import com.example.flow.model.base.Message;
import com.example.flow.model.base.impl.MessageImpl;
import com.example.flow.model.context.MessageDataDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/api/messagesSTP")

public class StpMessageController {

    private final STPFlow stpFlow;

    public StpMessageController(STPFlow stpFlow) {
        this.stpFlow = stpFlow;
    }


    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity createMessage(@RequestBody MessageDataDto message) {
        log.info("Received Message is {}....................",message);
        Message message1 = MessageImpl.builder().content(message).receivedAt(LocalDateTime.now()).build();
        stpFlow.executeMessageFlow(message1);
        log.info("createMessage....................");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
