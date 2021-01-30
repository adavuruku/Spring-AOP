package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyCloudLogAsyncAspect {
	
//	@Before("com.luv2code.aopdemo.aspect.MyDemoLoggingAspect.beforeAddAccountAdviceTwo()") // this wil
//	public void beforeAddAccountAdvice() {
//		System.out.println("\n======>> Async Mode");
//	}
}
