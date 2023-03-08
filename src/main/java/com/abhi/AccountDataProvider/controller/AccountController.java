package com.abhi.AccountDataProvider.controller;

import com.abhi.AccountDataProvider.dto.AccountDTO;
import com.abhi.AccountDataProvider.dto.AddAccountDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value = "/accounts",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
@Validated
@Tag(name = "Account Data Provider",description = "API for all account related operations")
public interface AccountController {
    @PostMapping
    @Operation(summary = "create new account")
    ResponseEntity<AccountDTO> add(@RequestBody @Valid AddAccountDTO addAccountDTO);

    @GetMapping
    @Operation(summary = "get all accounts ")
    ResponseEntity<List<AccountDTO>> getAccounts();
}
