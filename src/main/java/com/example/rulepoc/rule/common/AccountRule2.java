package com.example.rulepoc.rule.common;

import com.example.rulepoc.model.AccountModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AccountRule2 implements AccountRule {
    @Override
    public void apply(AccountModel accountModel) {

        log.info("AccountRule2 {}", accountModel.getAccountNumber());
    }


}
