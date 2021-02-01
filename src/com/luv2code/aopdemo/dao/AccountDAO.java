package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;
	
	
	public String getName() {
		System.out.println("in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println("in setName(String name)");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println("in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println("in setServiceCode(String serviceCode)");
		this.serviceCode = serviceCode;
	}

	public void addAccount() {
		System.out.println(getClass() +" Doin my DB Work :Adding An Account");
	}
	
	public void addUser() {
		System.out.println(getClass() +" Doin my DB Work :Adding A User");
	}
	
	public List<Account> findAccounts(){
		List<Account> myAccounts = new ArrayList<Account>();
		myAccounts.add(new Account("Sherif", "Gold"));
		myAccounts.add(new Account("Ahmad", "Silver"));
		myAccounts.add(new Account("Monrel", "Platinum"));
		return myAccounts;
	}
	
	public List<Account> findAccountsException(boolean ggg){
		if(ggg) {
			throw new RuntimeException("Yuppy");
		}
		List<Account> myAccounts = new ArrayList<Account>();
		myAccounts.add(new Account("Sherif", "Gold"));
		myAccounts.add(new Account("Ahmad", "Silver"));
		myAccounts.add(new Account("Monrel", "Platinum"));
		return myAccounts;
	}
	
	public String findAccountsExceptionTwo(boolean ggg){
		if(ggg) {
			throw new RuntimeException("Error Don Happen");
		}
		
		return "Yeap Executed No Error";
	}
	
	public String findAccountsTest(){
		try {
			TimeUnit.SECONDS.sleep(5);
			
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		return "Expect heavy traffic this morning";
	}
}

