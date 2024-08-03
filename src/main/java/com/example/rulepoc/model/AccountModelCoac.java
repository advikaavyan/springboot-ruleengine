package com.example.rulepoc.model;

public class AccountModelCoac implements AccountModel {
    private String accountNumber;
    private String coacAttribute1;

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCoacAttribute1() {
        return coacAttribute1;
    }

    public void setCoacAttribute1(String coacAttribute1) {
        this.coacAttribute1 = coacAttribute1;
    }
}