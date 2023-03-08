package com.abhi.AccountDataProvider.repository;

import com.abhi.AccountDataProvider.entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends MongoRepository<Account,String> {
}
