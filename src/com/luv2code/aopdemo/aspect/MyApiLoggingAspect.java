package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2) // order is to specify the execution peiority of the aop - the lower the number the higher the priority
public class MyApiLoggingAspect {

	
	//Match addAccount method of void return type in any  class 
	@Before("execution(public void addAccount())") // this wil
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n======>> Peforming API Analytics ");
	}
	
}
