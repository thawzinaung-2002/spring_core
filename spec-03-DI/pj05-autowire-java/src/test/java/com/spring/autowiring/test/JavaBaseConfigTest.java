package com.spring.autowiring.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.core.MyConfiguration;
import com.spring.core.autowired.MyClient;

public class JavaBaseConfigTest {

	@Test
	void test() {
		try(var context=new AnnotationConfigApplicationContext(MyConfiguration.class)) {
			
			var client = context.getBean(MyClient.class);
			client.showMessage();
			
		}
	}
	
}
