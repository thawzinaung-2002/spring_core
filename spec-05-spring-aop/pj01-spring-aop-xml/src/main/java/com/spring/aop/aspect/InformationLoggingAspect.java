package com.spring.aop.aspect;

import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InformationLoggingAspect {

	public void before(JoinPoint joinPoint) {
		
		System.out.printf("""
				toString		: %s
				toShortString	: %s
				toLongString	: %s
				kind			: %s
				signature		: %s
				sourceLocation	: %s
				""",
				joinPoint.toString(),
				joinPoint.toShortString(),
				joinPoint.toLongString(),
				joinPoint.getKind(),
				joinPoint.getSignature(),
				joinPoint.getSourceLocation());
		
		for(var input: joinPoint.getArgs()) {
			System.out.printf("Input : %s%n", input);
		}
	}
	
	public void after() {
		System.out.printf("EndAt : %s%n", LocalDateTime.now());
	}
	
	public void afterReturning(Object result) {
		System.out.printf("Result is : %s%n", result);
	}
	
}
