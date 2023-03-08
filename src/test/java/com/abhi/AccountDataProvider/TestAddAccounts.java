package com.abhi.AccountDataProvider;

import com.abhi.AccountDataProvider.common.vo.AccountStatus;
import com.abhi.AccountDataProvider.common.vo.AccountType;
import com.abhi.AccountDataProvider.dto.AccountDTO;
import com.abhi.AccountDataProvider.dto.AddAccountDTO;
import com.abhi.AccountDataProvider.repository.AccountRepo;
import com.abhi.AccountDataProvider.service.AccountService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class TestAddAccounts {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    AccountRepo accountRepo;
    @Autowired
    AccountService accountService;

    private ObjectMapper objectMapper;
    private AddAccountDTO testAddAc;
    private  String testAddAcJson;


    @BeforeEach
    void setup() throws JsonProcessingException{
        List notes = new ArrayList<>();
        notes.add("Accout notes added");
        testAddAc=new AddAccountDTO();
        testAddAc.setAccountType(AccountType.CURRENT);
        testAddAc.setCustomerName("ASDFG");
        testAddAc.setNotes(notes);
        testAddAc.setAccountStatus(AccountStatus.ACTIVE);
        testAddAc.setRegion("ASIA");

        objectMapper=new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        testAddAcJson= objectMapper.writeValueAsString(testAddAc);
    }
    @Test
    @DisplayName("Add Account test")
    void testAddAccount() throws Exception {

        MvcResult mvcResult=mockMvc.perform(
                        post("/accounts")
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON_VALUE)
                                .content(testAddAcJson)

                )
                .andDo(print())
                .andReturn();


        String contentAsString=mvcResult.getResponse().getContentAsString();
        AccountDTO accountDTO=objectMapper.readValue(contentAsString, AccountDTO.class);

        log.info("accountDTO:"+accountDTO);
        Assertions.assertAll(
                ()->Assertions.assertNotNull(accountDTO.getAccountId())
        );

    }
}
