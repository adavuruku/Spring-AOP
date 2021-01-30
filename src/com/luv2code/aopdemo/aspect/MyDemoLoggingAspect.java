package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(1)
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
	 * 
	 * 
	 * Parameter PCEL
	 * 
	 * @Before("execution(public void addAccount(...))") any addAccount() method with zero or more parameter of any type
	 * 
	 * @Before("execution(public void addAccount(*))") any addAccount() method with one parameter of any type
	 * 
	 * @Before("execution(public void addAccount())") any addAccount() method with zero parameter of any type
	 * 
	 * @Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount(...))") any addAccount() method in dao package with zero or more parameter of any type
	 * 
	 * @Before("execution(public void com.luv2code.aopdemo.*.*.addAccount(..))") any addAccount() method in any package dao and any class in dao package with zero or more parameter of any type
	 * */
	
	
	/*//Match addAccount method of void return type in any  class 
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
	
	//point cut re usable in other advice
	
	// (1) - match all method in all classes in dao paackage
	@Pointcut("execution (* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	//execute before (1)
	@Before("forDaoPackage()")
	public void beforeAddAccountAdviceKo() {
		System.out.println("\n======>> Executing @Before advice on method");
	}
	
	//execute before (1)
	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		System.out.println("\n======>> Performing API Analytics");
	}
	
	//{2} point to only  method that start with get in dao
	@Pointcut("execution (* com.luv2code.aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	//{3} point to only  method that start with setter in dao
	@Pointcut("execution (* com.luv2code.aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	//execute before for only (1) excluding (2) and (3)
	//that is execute for only forDaoPackage but not when set and getter advice is called
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void performNotForGetterAndSetter() {
		System.out.println("\n======>> This will not work for any method that start with get or set");
	}
	
	@Before("execution(public void addAccount())") // this wil
	public void beforeAddAccountAdvice() {
		System.out.println("\n======>> Executing @Before advice on addAccount() FROm Demo");
	}
	
	@Pointcut("execution(public void addAccount())") // this wil
	public void beforeAddAccountAdviceTwo() {
		System.out.println("\n======>> Executing Inherited FROm Demo");
	}*/
	
	/* 
	 * @AfterReturning
	 * Execute after the method finish executing
	 * 
	 * after returning can also be use to transform/modify the data return from a method
	 */
	 
	@AfterReturning("execution(public * findAccounts())")
	public void beforeAddAccountAdviceTwo() {
		System.out.println("\n======>> Executing Afterr Return");
	}
	
	@AfterReturning(
			pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning = "result")
	public void afterReturningFindAccountsAdvice(
			JoinPoint theJointPoint, List<Account> result) {
		
		String methodString = theJointPoint.getSignature().toShortString();
		
		System.out.println("\n======>> Executing Afterr Returning on method: "+ methodString);
		
		System.out.println("\n======>> Executing Afterr Returning on Result: "+ result);
		convertAccountNamesToUpperCase(result);
		
	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
		// TODO Auto-generated method stub
		for(Account accn: result) {
			String theUpperNmeString= accn.getName().toUpperCase();
			accn.setName(theUpperNmeString);
		}
	}
	
	/*
	 * @AfterThrowing is executed after a call to a function throw an exception
	 * 
	 * */
	
	@AfterThrowing(
			pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccountsException(..))",
			throwing = "theExc")
	public void afterThrowingFindAccountsAdvice(
			JoinPoint theJointPoint, Throwable theExc) {
		
		
		System.out.println("\n======>> Executing Afterr Throwing The Exception : "+ theExc);
		
		
	}
}
