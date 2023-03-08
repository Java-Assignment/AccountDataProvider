package com.abhi.AccountDataProvider.service;

import com.abhi.AccountDataProvider.dto.AccountDTO;
import com.abhi.AccountDataProvider.dto.AddAccountDTO;

import java.util.List;

public interface AccountService {
    AccountDTO add(AddAccountDTO addAccountDTO);

    List<AccountDTO> getAccounts();
}
