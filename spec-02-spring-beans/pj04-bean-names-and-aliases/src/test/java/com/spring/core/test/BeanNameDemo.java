package com.spring.core.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.core.MyConfig;
import com.spring.core.beans.MyService;

public class BeanNameDemo {

	@Test
	void demo() {
		try (var context= new AnnotationConfigApplicationContext(MyConfig.class)) {
			
			var bean = context.getBean("aliasone");
			
			if(bean instanceof MyService service) {
				System.out.println(service.message());
			}
			
		}
	}
	
}
