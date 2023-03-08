package com.abhi.AccountDataProvider.service;

import com.abhi.AccountDataProvider.entity.AccountNumber;
import com.abhi.AccountDataProvider.repository.AccountNumberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class AccountNumberServiceImpl implements AccountNumberService {
    private AccountNumberRepo accountNumberRepo;

    public AccountNumberServiceImpl(AccountNumberRepo accountNumberRepo) {
        this.accountNumberRepo = accountNumberRepo;
    }

    @Override
    @Retryable(value = OptimisticLockingFailureException.class, maxAttempts = 15)
    public String getNewAccountNumber() {
        try {
            AccountNumber accountNumber = accountNumberRepo.findAll().get(0);
            long newAcNumber = accountNumber.getAccountNumber() + 1;
            accountNumber.setAccountNumber(newAcNumber);
            accountNumberRepo.save(accountNumber);
            return String.format("%010d", newAcNumber);
        } catch (OptimisticLockingFailureException e) {
            throw e;
        }

    }
}
