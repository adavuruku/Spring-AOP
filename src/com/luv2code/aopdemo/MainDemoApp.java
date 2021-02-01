package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
//		theAccountDAO.addAccount();
//		System.out.println(" \nLets Call it Again \n");
//		theAccountDAO.addAccount();
//		
//		System.out.println(" \nAccessing Add User \n");
//		theAccountDAO.addUser();
//		
//		System.out.println(" \nRunning Member \n");
//		theMembershipDAO.addAccount();
//		theAccountDAO.setName("foobar");
//		
//		theAccountDAO.setServiceCode("Silver");
//		
//		String codeString = theAccountDAO.getServiceCode();
//		
//		String nameString = theAccountDAO.getName();
		
//		theAccountDAO.addAccount();
//		try {
//			List<Account> theAccountskk =  theAccountDAO.findAccountsException(false);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		
//		List<Account> theAccounts =  theAccountDAO.findAccounts()
//		
//		System.out.println(theAccounts);
//		
//		for(Account ac: theAccounts) {
//			System.out.println(ac.getName());
//		}
		
		theAccountDAO.findAccountsExceptionTwo(true);
		context.close();
	}

}
