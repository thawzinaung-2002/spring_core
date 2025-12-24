package com.spring.core.beans;

public class MyService {
	
	private String data1;
	private String data2;
	
	public MyService(String data1, String data2) {
		super();
		this.data1 = data1;
		this.data2 = data2;
	}

	public String message() {
		return data1 + " : "+ data2;
	}
	
}
