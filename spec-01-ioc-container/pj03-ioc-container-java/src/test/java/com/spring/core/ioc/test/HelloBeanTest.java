package com.spring.core.ioc.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.core.ioc.ApplicationConfig;
import com.spring.core.ioc.HelloBean;
import com.spring.core.ioc.beans.AnnotatedBean;

public class HelloBeanTest {
	
	@Test
	void test() {
		try(var context=new AnnotationConfigApplicationContext(ApplicationConfig.class)) {
			
			var hello = context.getBean(HelloBean.class);
			System.out.println(hello.sayHello());
			
			var annotated = context.getBean(AnnotatedBean.class);
			System.out.println(annotated.sayHello());
		}
	}

}
