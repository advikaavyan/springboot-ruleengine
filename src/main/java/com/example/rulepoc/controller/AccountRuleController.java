package com.example.rulepoc.controller;

import com.example.rulepoc.model.AccountModel;
import com.example.rulepoc.model.AccountModelCoac;
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

@Slf4j
@RestController
@RequestMapping("/api/enriches")
@RequiredArgsConstructor
public class AccountRuleController {

    private final AccountRuleService accountRuleService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    @Transactional
    public ResponseEntity processRuleRequest(@RequestBody String inMessage) {
        AccountModel accountModel = transformToAccountModel(inMessage);
        accountRuleService.process(accountModel);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    private AccountModel transformToAccountModel(String inMessage) {
        if (inMessage.startsWith("Coac")) {
            AccountModelCoac accountModelCoac = new AccountModelCoac();
            accountModelCoac.setAccountNumber("12345");
            accountModelCoac.setCoacAttribute1("Specific Data");
            return accountModelCoac;
        }

        if (inMessage.startsWith("Otc")) {
            AccountModelCoac accountModelCoac = new AccountModelCoac();
            accountModelCoac.setAccountNumber("12345");
            accountModelCoac.setCoacAttribute1("Specific Data");
            return accountModelCoac;
        }
        return null;
    }
}
