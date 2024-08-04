package com.example.rulepoc.rule;

import com.example.rulepoc.model.AccountModel;
import com.example.rulepoc.model.AccountModelCoac;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AccountRuleCoac implements Rule {
    @Override
    public void apply(AccountModel message) {
        if (message instanceof AccountModelCoac) {
            AccountModelCoac accountModelCoac = (AccountModelCoac) message;
            log.info("Ready to run COAC specific rules....");
            runCoacAccountRule1(accountModelCoac);
            runCoacAccountRule2(accountModelCoac);
        }
    }

    private void runCoacAccountRule1(AccountModelCoac message) {
        log.info("runCoacAccountRule1 executed");
    }

    private void runCoacAccountRule2(AccountModelCoac message) {
        log.info("runCoacAccountRule2 executed");
    }

}