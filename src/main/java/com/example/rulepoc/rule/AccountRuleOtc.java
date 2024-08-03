package com.example.rulepoc.rule;

import com.example.rulepoc.ValidationException;
import com.example.rulepoc.model.AccountModel;
import com.example.rulepoc.model.AccountModelCoac;

public class AccountRuleOtc implements Rule {
    @Override
    public void apply(AccountModel message) throws ValidationException {
        if (message instanceof AccountModelCoac) {
            AccountModelCoac messageTypeA = (AccountModelCoac) message;
            // Specific validation logic for MessageTypeA
            if (messageTypeA.getCoacAttribute1() == null || messageTypeA.getCoacAttribute1().isEmpty()) {
                throw new ValidationException("Specific attribute A is invalid");
            }
        }
    }
}