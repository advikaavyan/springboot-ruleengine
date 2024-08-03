package com.example.rulepoc.model;

public class AccountModelOtc implements AccountModel {
    private String accountNumber;
    private String otcAttribute1;

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOtcAttribute1() {
        return otcAttribute1;
    }

    public void setOtcAttribute1(String otcAttribute1) {
        this.otcAttribute1 = otcAttribute1;
    }
}