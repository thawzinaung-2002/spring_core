package com.spring.core.di.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.core.di.MyClient;

public class ExplicitWiringDemo {

	@Test
	void demo() {
		try(var context=new GenericXmlApplicationContext("classpath:/application.xml")) {
			
			var client1 = context.getBean("client1", MyClient.class);
			client1.showMessage();
			
			var client2 = context.getBean("client2", MyClient.class);
			client2.showMessage();
		}
	}
	
}
