package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	/*
	 * Point Cut Expression Language
	 * 
	 * @Before("execution(public void addAccount())") - match method addAccount() in any class
	 * 
	 * @Before("execution(public String addAccount())") - match method addAccount() of String return type in any class
	 * 
	 * @Before("execution(* * addAccount())") OR @Before("execution(* addAccount())") - match method addAccount() of any return type and modifier(OPTIONAL) in any class
	 * 
	 * @Before("execution(* * addAccount*())") - match method that start with addAccount() of any return type and modifier in any class
	 * */
	
	
	//Match addAccount method of void return type in any  class 
	@Before("execution(public void addAccount())") // this wil
	public void beforeAddAccountAdvice() {
		System.out.println("\n======>> Executing @Before advice on addAccount()");
	}
	
	
	//Match addAccount method of String return type in any  class 
	@Before("execution(public String addAccount())")
	public void beforeAddAccountAdviceTwo() {
		System.out.println("\n======>> Executing @Before advice on addAccount() String Return");
	}
	
	//Match addAccount method of void return type in any  AccountDAO class (note all the package path included)
	@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
	public void beforeAddAccountAdviceThree() {
		System.out.println("\n======>> Executing @Before advice on addAccount() - For Only AccountDAO");
	}
	
	//Match addAccount method of void return type and start with add (i.e addCoach, addSible etc
		@Before("execution(public void add*())")
		public void beforeAddAccountAdviceFour() {
			System.out.println("\n======>> Executing @Before advice on addAccount() - Start with add");
		}
}
