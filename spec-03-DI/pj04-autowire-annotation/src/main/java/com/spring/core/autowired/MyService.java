package com.spring.core.autowired;

import org.springframework.stereotype.Component;

@Component
public class MyService {

	public String getMessage() {
		return "Hello from MyService";
	}
	
}
