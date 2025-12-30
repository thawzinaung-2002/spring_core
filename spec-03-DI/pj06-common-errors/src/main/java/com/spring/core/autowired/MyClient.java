package com.spring.core.autowired;

import org.springframework.beans.factory.annotation.Autowired;

public class MyClient {

	@Autowired
	private MyService service;
	
	public void showMessage() {
//		service.stream().forEach(s -> System.out.println(s.getMessage()));
		System.out.println(service.getMessage());
	}
	
}
