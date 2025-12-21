package com.spring.core.ioc;

import org.springframework.stereotype.Component;

@Component
public class AnnotatedBean {

	public String sayHello() {
		return "Hello from annotated bean";
	}
}
