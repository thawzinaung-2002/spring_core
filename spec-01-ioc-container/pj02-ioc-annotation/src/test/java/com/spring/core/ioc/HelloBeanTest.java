package com.spring.core.ioc;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloBeanTest {

	@Test
	void test() {
		try(var context = new AnnotationConfigApplicationContext("com.spring.core.ioc")) {
			var bean = context.getBean(HelloBean.class);
			System.out.println(bean.sayHello());
		}
	}
	
}
