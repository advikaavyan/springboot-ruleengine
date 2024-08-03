package com.example.rulepoc.rule;

import com.example.rulepoc.ValidationException;
import com.example.rulepoc.model.AccountModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RuleEngine {
    private List<Rule> commonRules;
    private Map<Class<? extends AccountModel>, List<Rule>> productSpecificRules;

    public RuleEngine() {
        commonRules = new ArrayList<>();
        productSpecificRules = new HashMap<>();
    }

    public void addCommonRule(Rule rule) {
        commonRules.add(rule);
    }

    public void addSpecificRule(Class<? extends AccountModel> messageType, Rule rule) {
        productSpecificRules.computeIfAbsent(messageType, k -> new ArrayList<>()).add(rule);
    }

    public void applyRules(AccountModel message) throws ValidationException {
        // Apply common rules
        for (Rule rule : commonRules) {
            rule.apply(message);
        }

        // Apply specific rules
        List<Rule> rules = productSpecificRules.get(message.getClass());
        if (rules != null) {
            for (Rule rule : rules) {
                rule.apply(message);
            }
        }
    }
}