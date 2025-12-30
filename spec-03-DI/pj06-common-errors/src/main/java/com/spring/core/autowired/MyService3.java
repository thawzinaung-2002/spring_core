package com.spring.core.autowired;

import org.springframework.stereotype.Component;

import jakarta.annotation.Priority;

@Component
@Priority(1)
public class MyService3 implements MyService {

	@Override
	public String getMessage() {
		return "MyService3";
	}

}
