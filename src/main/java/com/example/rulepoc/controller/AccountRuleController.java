package com.example.rulepoc.controller;

import com.example.rulepoc.mapper.RequestMapper;
import com.example.rulepoc.model.AccountModel;
import com.example.rulepoc.service.AccountRuleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/api/enriches")
@RequiredArgsConstructor
public class AccountRuleController {

    private final AccountRuleService accountRuleService;
    private final RequestMapper requestMapper;

    @PostMapping(consumes = "application/json", produces = "application/json")
    @Transactional
    public ResponseEntity processRuleRequest(@RequestBody Map jsonMessage) {
        log.info("Request received....");
        long startTime = System.currentTimeMillis();
        AccountModel accountModel = requestMapper.transformToAccountModel(jsonMessage);
        if (Objects.nonNull(accountModel)) {
            accountRuleService.process(accountModel);
            log.info("Request full filled in {} :MS ", System.currentTimeMillis() - startTime);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        log.info("Request failed  in {} :MS ", System.currentTimeMillis() - startTime);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
