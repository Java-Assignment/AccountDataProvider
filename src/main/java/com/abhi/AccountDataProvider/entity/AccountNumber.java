package com.abhi.AccountDataProvider.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "accountnumber")
public class AccountNumber {
    @Id
    private String id;
    @Version
    private Long version;
    private Long accountNumber;
}
