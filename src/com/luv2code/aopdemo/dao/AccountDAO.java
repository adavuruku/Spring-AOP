package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

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
}
