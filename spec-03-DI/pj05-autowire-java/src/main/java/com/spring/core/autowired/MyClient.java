package com.spring.core.autowired;

public class MyClient {

	private MyService service;
	
	public void showMessage() {
		service.getMessage();
	}
	
}
