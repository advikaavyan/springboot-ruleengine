package com.example.rulepoc.rule.coac;

import com.example.rulepoc.model.AccountModel;
import com.example.rulepoc.model.AccountModelCoac;
import com.example.rulepoc.rule.Rule;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class CoacRuleRepository implements Rule {
    private final List<CoacRule> rules = List.of(new CoacRule1(), new CoacRule2(), new CoacRule3());

    public CoacRuleRepository() {
        log.info("CoacRuleRepository has {} rules configured", rules.size());
    }


    @Override
    public void apply(AccountModel accountModel) {
        log.info("Going to execute CoacRuleRepository's {} rules one by one", rules.size());
        if (accountModel instanceof AccountModelCoac) {
            for (CoacRule rule : rules) {
                rule.apply((AccountModelCoac) accountModel);
            }
        }
    }
}
