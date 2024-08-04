package com.example.rulepoc.service;

import com.example.rulepoc.RuleException;
import com.example.rulepoc.model.AccountModel;
import com.example.rulepoc.model.AccountModelCoac;
import com.example.rulepoc.model.AccountModelOtc;
import com.example.rulepoc.rule.RuleEngine;
import com.example.rulepoc.rule.RuleExecutor;
import com.example.rulepoc.rule.coac.CoacRuleRepository;
import com.example.rulepoc.rule.common.CommonRuleRepository;
import com.example.rulepoc.rule.otc.OtcRuleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AccountRuleService {
    private final RuleEngine ruleEngine = new RuleEngine();
    private final RuleExecutor ruleExecutor = new RuleExecutor(ruleEngine);

    AccountRuleService() {
        // add rules
        ruleEngine.addCommonRule(new CommonRuleRepository());
        // add COAC specific rules
        ruleEngine.addSpecificRule(AccountModelCoac.class, new CoacRuleRepository());
        // add OTC specific rules
        ruleEngine.addSpecificRule(AccountModelOtc.class, new OtcRuleRepository());
    }

    public void process(AccountModel accountModel) {
        try {
            ruleExecutor.execute(accountModel);
            log.info("All rules have been executed...");
        } catch (RuleException e) {
            log.info("All rules execution... failed: " + e.getMessage());
        }
    }
}