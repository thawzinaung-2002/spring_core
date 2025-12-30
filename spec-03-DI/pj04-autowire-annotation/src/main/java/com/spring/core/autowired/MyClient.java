package com.spring.core.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyClient {

//	@Autowired
	// Dependency
	private MyService service;

	@Autowired
	public MyClient(MyService service) {
		super();
		this.service = service;
	}

//	@Autowired
//	public void setService(MyService service) {
//		this.service = service;
//	}

	public void showMessage() {
		System.out.printf("%s \n", service.getMessage());
	}

}
