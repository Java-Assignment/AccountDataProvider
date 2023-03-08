package com.abhi.AccountDataProvider.entity;

import com.abhi.AccountDataProvider.common.vo.AccountStatus;
import com.abhi.AccountDataProvider.common.vo.AccountType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;
@Document(collection = "accountsdata")
@Data
@NoArgsConstructor
public class Account {
    @Id
    private String accountId;
    private AccountType accountType;
    private  String  customerName;
    private List<String> notes;
    private AccountStatus accountStatus;
    private  String region;
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private LocalDate createDate;

}
