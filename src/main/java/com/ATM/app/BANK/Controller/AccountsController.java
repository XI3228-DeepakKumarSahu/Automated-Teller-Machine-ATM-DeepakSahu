package com.ATM.app.BANK.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ATM.app.BANK.model.Accounts;
import com.ATM.app.BANK.repo.AccountsRepo;

@RestController
public class AccountsController {
	   @Autowired
	   private AccountsRepo repo;
	
	   @GetMapping("/getAccountsusers")
	   public List<Accounts> getAccountsusers()
	    {
	    return repo.findAll();		
	    }
	   
	   @PostMapping("/createUseraccount")
	   public String createUseraccount(@RequestBody Accounts model)
	    {
		   if(model.ACnumber == 0|| model.age == null|| model.id==0 || model.name==null )
		   {return "Pleace enter a proper input";}
		   else
		   {		   
	    repo.save(model);
	    return "created succesfully";		
		   }
		   }
	  
	
	
	
}
