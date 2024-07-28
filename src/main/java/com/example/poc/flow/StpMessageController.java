package com.example.poc.flow;

import com.example.poc.flow.impl.STPFlow;
import com.example.poc.flow.model.base.Message;
import com.example.poc.flow.model.base.impl.MessageImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional
    public ResponseEntity createMessage(@RequestBody String inMessage) {
        log.info("Trade Received {}....................");
        Long startTime = System.currentTimeMillis();
        Message message = MessageImpl.builder().content(inMessage).receivedAt(LocalDateTime.now()).build();
        stpFlow.executeMessageFlow(message);
        log.info("Trade processed successfully ....................in {}", System.currentTimeMillis() - startTime);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
