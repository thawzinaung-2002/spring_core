package com.spring.core.beans;

import org.springframework.stereotype.Component;

@Component
public class MyServiceTwo implements MyService{

	@Override
	public String message() {
		return "This is from MyServiceTwo";
	}

}
