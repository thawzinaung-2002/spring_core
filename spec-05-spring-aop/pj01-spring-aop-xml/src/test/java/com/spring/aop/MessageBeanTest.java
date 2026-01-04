package com.spring.aop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:/application.xml")
public class MessageBeanTest {

	@Autowired
	private MessageBean bean;
	
	@Autowired
	private OtherBean otherBean;
	
	@Test
	void test() {
		var result = bean.send("Hello AOP!");
		assertEquals(1, result);
		bean.hello("Hello");
		otherBean.show("Hello Other AOP!");
	}
	
}
