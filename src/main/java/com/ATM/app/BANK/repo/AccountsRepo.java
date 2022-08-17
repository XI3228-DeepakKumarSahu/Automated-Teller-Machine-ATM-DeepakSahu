package com.ATM.app.BANK.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ATM.app.BANK.model.Accounts;

public interface AccountsRepo  extends MongoRepository<Accounts, Integer>{

}
