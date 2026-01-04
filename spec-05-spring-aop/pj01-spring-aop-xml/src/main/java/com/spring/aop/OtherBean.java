package com.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class OtherBean {

	public void show(String message) {
		System.out.println(message);
	}
	
}
