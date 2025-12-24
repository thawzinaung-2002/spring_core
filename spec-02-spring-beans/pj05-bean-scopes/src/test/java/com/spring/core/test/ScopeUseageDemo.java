package com.spring.core.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.core.ApplicationConfig;
import com.spring.core.beans.MyService;

public class ScopeUseageDemo {

	@Test
	void test() {
		
		try(var context=new AnnotationConfigApplicationContext(ApplicationConfig.class)) {
			
			var s1 = context.getBean("myService", MyService.class);
			var s2 = context.getBean("myService", MyService.class);

			var p1 = context.getBean("prototypeService", MyService.class);
			var p2 = context.getBean("prototypeService", MyService.class);

			for(var i=0; i<=5; i++) {
				s1.addMessage("Message %s".formatted(i));
				s2.addMessage("Message %s".formatted(i));
				p1.addMessage("Message %s".formatted(i));
				p2.addMessage("Message %s".formatted(i));
			}
			
			s1.addMessage("Other Message");
			p1.addMessage("Other Message");
			
			System.out.println(s1.getMessages());
			System.out.println(s2.getMessages());
			System.out.println(p1.getMessages());
			System.out.println(p2.getMessages());
			
		}
		
	}
	
}
