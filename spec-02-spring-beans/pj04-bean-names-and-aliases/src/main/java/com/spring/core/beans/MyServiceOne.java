package com.spring.core.beans;

import org.springframework.stereotype.Component;

@Component
public class MyServiceOne implements MyService{

	@Override
	public String message() {
		return "This is from MyServiceOne";
	}

}
