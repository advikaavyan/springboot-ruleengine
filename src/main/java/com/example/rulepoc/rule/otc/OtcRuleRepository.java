package com.example.rulepoc.rule.otc;

import com.example.rulepoc.model.AccountModel;
import com.example.rulepoc.model.AccountModelOtc;
import com.example.rulepoc.rule.Rule;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
@Slf4j
public class OtcRuleRepository implements Rule {
    private final List<OtcRule> rules = List.of(new OtcRule1(), new OtcRule2());
    public  OtcRuleRepository(){
        log.info("OtcRuleRepository has {} rules configured", rules.size());
    }
    @Override
    public void apply(AccountModel accountModel) {
        log.info("Going to execute OtcRuleRepository's {} rules one by one", rules.size());
        if (accountModel instanceof AccountModelOtc) {
            for (OtcRule rule : rules) {
                rule.apply((AccountModelOtc) accountModel);
            }
        }
    }
}
