package com.example.rulepoc.rule.otc;

import com.example.rulepoc.model.AccountModelOtc;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OtcRule2 implements OtcRule {
    @Override
    public void apply(AccountModelOtc accountModel) {

        log.info("OtcRule2 {}", accountModel.getOtcAttribute1());
    }


}
