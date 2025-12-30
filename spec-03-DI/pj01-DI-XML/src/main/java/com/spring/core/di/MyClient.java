package com.spring.core.di;

public class MyClient {

	// Dependency
	private MyService service;
	private String name;
	
	public MyClient() {
		
	}
	
	public MyClient(MyService service, String name) {
		super();
		this.service = service;
		this.name = name;
	}

	public void setName(String name) {
		this.name=name;
	}

	public void setMyService(MyService service) {
		this.service = service;
	}

	public void showMessage() {
		System.out.printf("%s : %s\n",this.name, service.getMessage());
	}
	
}
