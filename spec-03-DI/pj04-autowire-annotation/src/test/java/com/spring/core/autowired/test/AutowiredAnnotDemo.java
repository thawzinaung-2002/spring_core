package com.spring.core.autowired.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.core.autowired.MyClient;

public class AutowiredAnnotDemo {

	
	@Test
	void test() {
		try(var context=new AnnotationConfigApplicationContext("com.spring.core.autowired")) {
			var bean=context.getBean(MyClient.class);
			bean.showMessage();
		}
	}
}
