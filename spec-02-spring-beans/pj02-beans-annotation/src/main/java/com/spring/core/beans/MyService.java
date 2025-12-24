package com.spring.core.beans;

import org.springframework.stereotype.Component;

@Component
//@AppBean
public class MyService {

	public MyService(String str) {
		
	}
	
	public String message() {
		return "Spring Bean Annotation Config Test";
	}
	
}
