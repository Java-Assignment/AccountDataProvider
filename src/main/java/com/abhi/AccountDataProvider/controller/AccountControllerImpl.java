package com.abhi.AccountDataProvider.controller;

import com.abhi.AccountDataProvider.dto.AccountDTO;
import com.abhi.AccountDataProvider.dto.AddAccountDTO;
import com.abhi.AccountDataProvider.mapper.AccountMapper;
import com.abhi.AccountDataProvider.repository.AccountRepo;
import com.abhi.AccountDataProvider.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AccountControllerImpl implements AccountController {
    @Autowired
    AccountService accountService;
    @Autowired
    AccountRepo accountRepo;

    @Autowired
    AccountMapper accountMapper;

    @Override
    public ResponseEntity<AccountDTO> add(AddAccountDTO addAccountDTO) {
        AccountDTO accountDTO1 = accountService.add(addAccountDTO);
        return new ResponseEntity<>(accountDTO1, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<AccountDTO>> getAccounts() {
        List<AccountDTO> accountDTO = accountService.getAccounts();
        return new ResponseEntity<>(accountDTO, HttpStatus.OK);
    }
}
