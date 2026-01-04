package com.spring.aop.pointcuts;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.aspectj.lang.JoinPoint;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PointCutAdvice {

	private static final DateTimeFormatter DF = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss");

	public void before(JoinPoint joinPoint) {

		var className = joinPoint.getTarget().getClass().getSimpleName();
		var methodName = joinPoint.getSignature().getName();
		var executeAt = LocalDateTime.now().format(DF);

		System.out.printf("%s#%s is executed at %s%n", className, methodName, executeAt);
	}

	public void beforeWithArgs(JoinPoint joinPoint, int count) {

		var className = joinPoint.getTarget().getClass().getSimpleName();
		var methodName = joinPoint.getSignature().getName();
		var executeAt = LocalDateTime.now().format(DF);

		System.out.printf("%s#%s is executed at %s%n", className, methodName, executeAt);
	}
}
