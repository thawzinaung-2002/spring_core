package com.spring.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:/around-demo.xml")
public class AroundAdviceTest {

	@Autowired
	private AdviceArgumentsDemo demo;
	
	@Test
	void test() {
		demo.getLength(null);
	}
	
}
