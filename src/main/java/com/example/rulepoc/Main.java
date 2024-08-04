package com.example.rulepoc;

import com.example.rulepoc.model.AccountModelCoac;
import com.example.rulepoc.model.AccountModelOtc;
import com.example.rulepoc.rule.*;

public class Main {
    public static void main11(String[] args) {
        try {
            // Create the rule engine and add rules
            RuleEngine ruleEngine = new RuleEngine();
            ruleEngine.addCommonRule(new AccountRule());
            ruleEngine.addSpecificRule(AccountModelCoac.class, new AccountRuleCoac());
            ruleEngine.addSpecificRule(AccountModelOtc.class, new AccountRuleOtc());

            // Create the validator
            RuleExecutor ruleExecutor = new RuleExecutor(ruleEngine);

            // Create a message and validate it
            AccountModelCoac message = new AccountModelCoac();
            message.setAccountNumber("12345");
            message.setCoacAttribute1("Specific Data");

            ruleExecutor.execute(message);

            System.out.println("Validation passed.");
        } catch (RuleException e) {
            System.out.println("Validation failed: " + e.getMessage());
        }
    }
}