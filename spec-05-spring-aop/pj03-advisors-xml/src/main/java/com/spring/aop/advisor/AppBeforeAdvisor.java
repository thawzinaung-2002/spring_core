package com.spring.aop.advisor;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

@Component
public class AppBeforeAdvisor implements MethodBeforeAdvice{

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.printf("Method name : %s%n", method.getName());
		System.out.printf("Arguments");
		var argNames = method.getParameters();
		for(var i=0; i<argNames.length; i++) {
			System.out.printf("%s : %s%n", argNames[i], argNames[i].getName());
		}
	}

}
