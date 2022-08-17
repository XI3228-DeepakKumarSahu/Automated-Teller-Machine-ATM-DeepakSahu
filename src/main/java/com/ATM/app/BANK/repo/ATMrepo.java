package com.ATM.app.BANK.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ATM.app.BANK.model.ATMModel;

public interface ATMrepo extends MongoRepository<ATMModel, Integer> {

	
	//public ATMModel withdraw(int id); 
	//public String withdraw(int id);
}
