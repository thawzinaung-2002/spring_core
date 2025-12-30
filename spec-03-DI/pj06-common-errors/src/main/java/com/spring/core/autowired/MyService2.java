package com.spring.core.autowired;

import org.springframework.stereotype.Component;

import jakarta.annotation.Priority;

@Component
@Priority(2)
public class MyService2 implements MyService {

	@Override
	public String getMessage() {
		return "MyService2";
	}

}
