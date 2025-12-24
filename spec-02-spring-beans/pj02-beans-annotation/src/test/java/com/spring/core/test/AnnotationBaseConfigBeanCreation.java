package com.spring.core.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.core.beans.MyService;

public class AnnotationBaseConfigBeanCreation {

	@Test
	void test() {
		try(var context = new AnnotationConfigApplicationContext("com.spring.core.beans")) {
			
			var service = context.getBean(MyService.class);
			System.out.println(service.message());
		}
	}
	
}
