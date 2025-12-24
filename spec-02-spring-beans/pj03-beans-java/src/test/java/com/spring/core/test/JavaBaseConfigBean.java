package com.spring.core.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.core.MyConfiguration;
import com.spring.core.beans.MyService;

public class JavaBaseConfigBean {

	@Test
	void test() {
		
		try(var context=new AnnotationConfigApplicationContext(MyConfiguration.class)) {
			
			var service = context.getBean(MyService.class);
			System.out.println(service.message());
			
		}
		
	}
	
}
