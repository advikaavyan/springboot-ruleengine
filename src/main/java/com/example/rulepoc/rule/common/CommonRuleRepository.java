package com.example.rulepoc.rule.common;

import com.example.rulepoc.model.AccountModel;
import com.example.rulepoc.rule.Rule;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class CommonRuleRepository implements Rule {
    private final List<AccountRule> rules = List.of(new AccountRule1(), new AccountRule2());

    public CommonRuleRepository() {
        log.info("CommonRuleRepository has {} rules configured", rules.size());
    }

    @Override
    public void apply(AccountModel accountModel) {
        log.info("Going to execute CommonRuleRepository's {} rules one by one", rules.size());
        for (AccountRule rule : rules) {
            rule.apply(accountModel);
        }
    }
}
