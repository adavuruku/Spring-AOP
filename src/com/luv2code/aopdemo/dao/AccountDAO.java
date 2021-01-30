package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	public void addAccount() {
		System.out.println(getClass() +" Doin my DB Work :Adding An Account");
	}
	
	public void addUser() {
		System.out.println(getClass() +" Doin my DB Work :Adding A User");
	}
}
