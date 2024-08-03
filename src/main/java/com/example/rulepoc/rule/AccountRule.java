package com.example.rulepoc.rule;

import com.example.rulepoc.ValidationException;
import com.example.rulepoc.model.AccountModel;
import com.example.rulepoc.rule.Rule;

public class AccountRule implements Rule {
    @Override
    public void apply(AccountModel message) throws ValidationException {
        // Common account number validation logic
        if (message.getAccountNumber() == null || message.getAccountNumber().isEmpty()) {
            throw new ValidationException("Account number is invalid");
        }
    }
}