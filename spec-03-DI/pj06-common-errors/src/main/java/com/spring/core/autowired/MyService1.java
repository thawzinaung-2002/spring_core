package com.spring.core.autowired;

import org.springframework.stereotype.Component;

import jakarta.annotation.Priority;

@Component
@Priority(3)
public class MyService1 implements MyService {

	@Override
	public String getMessage() {
		return "MyService1";
	}
	
}
