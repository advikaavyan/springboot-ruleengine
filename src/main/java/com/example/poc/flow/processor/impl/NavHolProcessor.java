package com.example.poc.flow.processor.impl;

import com.example.poc.flow.model.base.BaseContext;
import com.example.poc.flow.model.base.Transaction;
import com.example.poc.flow.model.context.Navhold;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class NavHolProcessor extends AbstractProcessor {
    @Override
    public BaseContext execute(final BaseContext baseContext) {
        Transaction transaction = getLatestTransaction(baseContext);
        String accountNumber = transaction.getMessageData().getAccountNumber();
        // api call

        Navhold navhold = new Navhold();
        navhold.setStartTime(LocalDateTime.now());
        navhold.setReleaseTime(LocalDateTime.now().plusHours(3));
        transaction.getNavhold().setStartTime(navhold.getStartTime());
        transaction.getNavhold().setReleaseTime(navhold.getReleaseTime());
        return baseContext;
    }
}
