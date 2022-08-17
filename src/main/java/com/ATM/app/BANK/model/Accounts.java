package com.ATM.app.BANK.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Accounts")
public class Accounts {

    
	public int id;
	@Id
	public int ACnumber;
	public String name;
	public String age;
	public int balance;

	@Override
	public String toString() {
		return "Accounts [id=" + id + ", ACnumber=" + ACnumber + ", name=" + name + ", age=" + age + ", balance="
				+ balance + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getACnumber() {
		return ACnumber;
	}
	public void setACnumber(int aCnumber) {
		ACnumber = aCnumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	
	
	
	
	
}
