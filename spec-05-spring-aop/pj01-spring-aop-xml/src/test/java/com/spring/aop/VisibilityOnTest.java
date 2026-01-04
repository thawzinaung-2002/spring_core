package com.spring.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:/visibility.xml")
public class VisibilityOnTest {

	@Autowired
	private VisibilityDemo demo;
	
	@Test
	void test() {
		
//		demo.publicMethod();
		
		demo.protectedMethod();
	}
	
}
