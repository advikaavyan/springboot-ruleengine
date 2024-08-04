package com.example.rulepoc.rule;

import com.example.rulepoc.model.AccountModel;
import com.example.rulepoc.model.AccountModelOtc;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AccountRuleOtc implements Rule {
    @Override
    public void apply(AccountModel message) {
        if (message instanceof AccountModelOtc) {
            AccountModelOtc accountModelOtc = (AccountModelOtc) message;
            log.info("Ready to run OTC specific rules....");
            runOtcAccountRule1(accountModelOtc);
            runOtcAccountRule2(accountModelOtc);
        }
    }

    private void runOtcAccountRule1(AccountModelOtc message) {
        log.info("runOtcAccountRule1 executed");
    }

    private void runOtcAccountRule2(AccountModelOtc message) {
        log.info("runOtcAccountRule2 executed");
    }
}