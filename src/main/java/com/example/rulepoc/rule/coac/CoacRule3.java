package com.example.rulepoc.rule.coac;

import com.example.rulepoc.model.AccountModelCoac;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CoacRule3 implements CoacRule {
    @Override
    public void apply(AccountModelCoac accountModel) {

        log.info("CoacRule3 {}", accountModel.getCoacAttribute1());
    }


}
