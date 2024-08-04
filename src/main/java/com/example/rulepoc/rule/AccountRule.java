package com.example.rulepoc.rule;

import com.example.rulepoc.model.AccountModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AccountRule implements Rule {
    @Override
    public void apply(AccountModel message) {
        runCommonAccountRule1(message);
        runCommonAccountRule2(message);
    }

    private void runCommonAccountRule1(AccountModel message) {
        log.info("runCommonAccountRule1 executed");
    }

    private void runCommonAccountRule2(AccountModel message) {
        log.info("runCommonAccountRule2 executed");
    }
}