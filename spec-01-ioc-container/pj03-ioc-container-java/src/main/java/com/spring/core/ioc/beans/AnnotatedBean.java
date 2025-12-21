package com.spring.core.ioc.beans;

import org.springframework.stereotype.Component;

@Component
public class AnnotatedBean {

	public String sayHello() {
		return "Hello from Annotated Bean Config";
	}
	
}
