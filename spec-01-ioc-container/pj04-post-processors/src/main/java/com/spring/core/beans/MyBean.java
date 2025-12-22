package com.spring.core.beans;

import org.springframework.stereotype.Component;

@Component
public class MyBean {

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
	
}
