package com.example.rulepoc.service;

import com.example.rulepoc.rule.RuleExecutor;
import com.example.rulepoc.ValidationException;
import com.example.rulepoc.model.AccountModel;
import com.example.rulepoc.model.AccountModelCoac;
import com.example.rulepoc.model.AccountModelOtc;
import com.example.rulepoc.rule.AccountRule;
import com.example.rulepoc.rule.AccountRuleCoac;
import com.example.rulepoc.rule.AccountRuleOtc;
import com.example.rulepoc.rule.RuleEngine;
import org.springframework.stereotype.Service;

@Service
public class AccountRuleService {

    private final RuleEngine ruleEngine = new RuleEngine();
    private final RuleExecutor ruleExecutor = new RuleExecutor(ruleEngine);

    AccountRuleService() {
        // add rules
        ruleEngine.addCommonRule(new AccountRule());
        // add Coac specific rules
        ruleEngine.addSpecificRule(AccountModelCoac.class, new AccountRuleCoac());
        // add Otc specific rules
        ruleEngine.addSpecificRule(AccountModelOtc.class, new AccountRuleOtc());
    }

    public void process(AccountModel accountModel) {
        try {
            ruleExecutor.execute(accountModel);
            System.out.println("Validation passed.");
        } catch (ValidationException e) {
            System.out.println("Validation failed: " + e.getMessage());
        }
    }
}