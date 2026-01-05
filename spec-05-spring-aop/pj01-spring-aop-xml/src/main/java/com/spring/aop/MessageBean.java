package com.spring.aop;

import org.springframework.stereotype.Service;

import com.spring.aop.annotations.SecuredArgs;
import com.spring.aop.annotations.SecuredMethod;
import com.spring.aop.annotations.SecuredService;

@Service
@SecuredService
public class MessageBean implements MessageService {

	private int times = 0;
	
	@Override
	public int send(@SecuredArgs String message) {
	
		System.out.printf("Sending Message : %s%n", message);
		times++;
		return times++;
	}
	
	@SecuredMethod
	@Override
	public void hello(String message) {
		System.out.printf("Hello Message : %s%n", message);
	}
	
}
