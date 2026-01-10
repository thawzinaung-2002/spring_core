package com.spring.introduction;

import org.springframework.stereotype.Service;

@Service
public class MyService {

	public void send(String message) {
		System.out.printf("MyService is %s%n", message);
	}

}
