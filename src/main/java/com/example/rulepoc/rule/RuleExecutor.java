package com.example.rulepoc.rule;

import com.example.rulepoc.ValidationException;
import com.example.rulepoc.model.AccountModel;

public class RuleExecutor {
    private RuleEngine ruleEngine;

    public RuleExecutor(RuleEngine ruleEngine) {
        this.ruleEngine = ruleEngine;
    }

    public void execute(AccountModel message) throws ValidationException {
        ruleEngine.applyRules(message);
    }
}