package com.abhi.AccountDataProvider.mapper;


import com.abhi.AccountDataProvider.dto.AccountDTO;
import com.abhi.AccountDataProvider.dto.AddAccountDTO;
import com.abhi.AccountDataProvider.entity.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {


    AccountDTO convertAddAccountDTOtoAccountDTO(AddAccountDTO addAccountDTO);

    Account convertAccountDTOtoAccount(AccountDTO accountDTO);

    AccountDTO convertSavedAccounttoAccountDTO(Account savedAccount);

    AccountDTO convertActoAccountDTO(Account a);
}
