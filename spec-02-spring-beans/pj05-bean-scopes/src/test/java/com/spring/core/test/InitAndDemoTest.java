package com.spring.core.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.core.beans.InitializableBean;

public class InitAndDemoTest {

	@Test
	void demo() {
		
		try(var context=new AnnotationConfigApplicationContext("com.spring.core.beans")) {
			
			var bean=context.getBean(InitializableBean.class);
			assertNotNull(bean);
			
		}
	}
	
}
