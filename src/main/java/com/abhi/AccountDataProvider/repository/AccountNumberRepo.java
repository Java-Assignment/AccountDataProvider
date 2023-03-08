package com.abhi.AccountDataProvider.repository;

import com.abhi.AccountDataProvider.entity.AccountNumber;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountNumberRepo extends MongoRepository<AccountNumber,String> {
}
