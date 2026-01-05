package com.spring.other;


import org.springframework.stereotype.Service;

import com.spring.aop.annotations.SecuredService;

@SecuredService
@Service
public class OtherMessageSender {
    
	public void send(int count, String message) {
		for(var i=0; i<count; i++) {
			System.out.printf("Other Message Sender : %s%n", message);
		}
	}
	
	public void send(String message) {
		System.out.printf("Other Message Sender : %s%n", message);
	}
	
	public void send(int count) {
		System.out.printf("Other Message Sender : %d%n", count);
	}
}
