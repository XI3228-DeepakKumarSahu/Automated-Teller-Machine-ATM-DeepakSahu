package com.ATM.app.BANK.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ATM.app.BANK.model.ATMModel;
import com.ATM.app.BANK.repo.ATMrepo;

@RestController
public class ATMcontroller {
       
	
	   @Autowired
	   private ATMrepo repo;
	   
	   @PostMapping("/createaccount")
	   public String createaccount(@RequestBody ATMModel model)
	    {
		   if(model.ACnumber == 0|| model.age == null|| model.id==0 || model.name==null )
		   {return "Pleace enter a proper input";}
		   else
		   {		   
	    repo.save(model);
	    return "created succesfully";		
		   }
		   }
	   
	   @GetMapping("/getusers")
	   public List<ATMModel> showusers()
	    {
	    return repo.findAll();		
	    }
	   
	   @GetMapping("/user/{id}")
	   public Optional<ATMModel> user(@PathVariable int id)
	    {
	    return repo.findById(id);		
	    }
	   
	   
	   
	   
	  @GetMapping("/balance/{id}")
	   public String checkbalance( @PathVariable int id, ATMModel model)
	    {
		   Optional<ATMModel> bal=repo.findById(id);
		   ATMModel specificuser = bal.get();
		 
		   if(repo.findById(id) ==null)
		   {return "no record found";}   
		   else
		   {
	    return "current balance is = "+specificuser.balance;		
	    }
	    
	    }
	   
	  
	   @PutMapping("/deposit/{id}/{amount}")
	   public String deposit(@PathVariable int id ,@PathVariable int amount)
	   {
           ATMModel model= repo.findById(id).orElseThrow();
           if(amount==0)
           {
        	   return "INVALID AMOUNT , AMOUNT CAN NOT BE ZERO";
        	   
           }
           else
           {
		   model.setBalance(model.balance+amount);
		   repo.save(model);
		   return "updated succesfully(deposit)";
	   }
	   
	   }
	   
	   
	   
	   @PutMapping("/withdraw/{id}/{amount}")
	   public String withdraw(@PathVariable int id ,@PathVariable int amount)
	   {
		   
		   ATMModel model= repo.findById(id).orElseThrow();
		   
		   if(amount==0)
           {
        	   return "INVALID AMOUNT , AMOUNT CAN NOT BE ZERO";
        	   
           }
		   else if(amount>model.balance)
		   {
			   return "LOW BALANCE";   
		   }
		   else
		   {
		   model.setBalance(model.balance-amount);
		   repo.save(model);
		   return "updated succesfully(withdraw)";
	   }
	   
	   }
	   
	   
	   
	   
	   @PutMapping("/{transferfromid}/{amount}/{transfertoid}")
	   public String MoneyTransfer(@PathVariable int transferfromid ,@PathVariable int amount,@PathVariable int  transfertoid)
	   { 
		   ATMModel model= repo.findById(transferfromid).orElseThrow();
		   ATMModel model1= repo.findById(transfertoid).orElseThrow();
		 
		   if(amount>model.balance)		   
		   {
			   return "LOW BALANCE";    
		   }
		   else
		   {
		   
		   model.setBalance(model.balance-amount);
		   repo.save(model);
		   model1.setBalance(model1.balance+amount);
		   repo.save(model1);
		   return "transfer succesfully from "+transferfromid+" to " + transfertoid;
	   }
	   
	   }
	   
}
