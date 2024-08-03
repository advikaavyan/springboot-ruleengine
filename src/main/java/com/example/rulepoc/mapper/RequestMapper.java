package com.example.rulepoc.mapper;

import com.example.rulepoc.model.AccountModel;
import com.example.rulepoc.model.AccountModelCoac;
import com.example.rulepoc.model.AccountModelOtc;
import com.example.rulepoc.model.ProductKey;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RequestMapper {

    public AccountModel transformToAccountModel(Map jsonMessage) {
        ProductKey productKey = ProductKey.valueOf(String.valueOf(jsonMessage.get("product")));
        switch (productKey) {
            case COAC:
                return createCoac(jsonMessage);
            case OTC:
                return createOtc(jsonMessage);
        }
        return null;
    }

    public AccountModel createCoac(Map jsonMessage) {
        AccountModelCoac model = new AccountModelCoac();
        model.setAccountNumber("12345");
        model.setCoacAttribute1("COAC");
        return model;

    }

    public AccountModel createOtc(Map jsonMessage) {
        AccountModelOtc model = new AccountModelOtc();
        model.setAccountNumber("12345");
        model.setOtcAttribute1("OTC ");
        return model;

    }

}
