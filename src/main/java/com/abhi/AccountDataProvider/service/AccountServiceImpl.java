package com.abhi.AccountDataProvider.service;

import com.abhi.AccountDataProvider.dto.AccountDTO;
import com.abhi.AccountDataProvider.dto.AddAccountDTO;
import com.abhi.AccountDataProvider.entity.Account;
import com.abhi.AccountDataProvider.mapper.AccountMapper;
import com.abhi.AccountDataProvider.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountMapper accountMapper;
    @Autowired
    AccountRepo accountRepo;
    @Autowired
    AccountNumberService accountNumberService;

    @Override
    public AccountDTO add(AddAccountDTO addAccountDTO) {
        AccountDTO accountDTO = accountMapper.convertAddAccountDTOtoAccountDTO(addAccountDTO);
        Account account = accountMapper.convertAccountDTOtoAccount(accountDTO);
        account.setCreateDate(LocalDate.now());
        account.setAccountId(accountNumberService.getNewAccountNumber());
        Account savedAccount = accountRepo.save(account);
        AccountDTO accountDTO1 = accountMapper.convertSavedAccounttoAccountDTO(savedAccount);
        return accountDTO1;
    }

    @Override
    public List<AccountDTO> getAccounts() {
        List<AccountDTO> accounts = accountRepo.findAll().stream().map(a -> accountMapper.convertActoAccountDTO(a)).toList();
        return  accounts;
    }
}

