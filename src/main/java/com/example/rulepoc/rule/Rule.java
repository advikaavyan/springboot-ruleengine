package com.example.rulepoc.rule;

import com.example.rulepoc.ValidationException;
import com.example.rulepoc.model.AccountModel;

public interface Rule {
    void apply(AccountModel message) throws ValidationException;
}