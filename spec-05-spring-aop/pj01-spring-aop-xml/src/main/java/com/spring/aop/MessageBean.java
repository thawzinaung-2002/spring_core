package com.spring.aop;

import org.springframework.stereotype.Service;

@Service
public class MessageBean implements MessageService {

	private int times = 0;
	
	@Override
	public int send(String message) {
	
		System.out.printf("Sending Message : %s%n", message);
		times++;
		return times++;
	}
	
	public void hello(String message) {
		System.out.printf("Hello Message : %s%n", message);
	}
	
}
