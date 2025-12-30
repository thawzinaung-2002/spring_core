package com.spring.autowiring.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CircularDependency {

	@Test
	void test() {
		try(var context=new AnnotationConfigApplicationContext()) {
			
		}
	}
	
}
