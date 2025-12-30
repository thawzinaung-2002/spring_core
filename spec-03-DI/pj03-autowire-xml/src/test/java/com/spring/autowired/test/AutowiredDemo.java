package com.spring.autowired.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.core.autowired.MyClient;

public class AutowiredDemo {

	@Test
	void demo() {
		try(var context=new GenericXmlApplicationContext("classpath:/application.xml")) {
			
			var client=context.getBean(MyClient.class);
			client.showMessage();
			
		}
	}
	
}
