package com.spring.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.spring.other.OtherMessageSender;

@SpringJUnitConfig(locations = "classpath:/point-cuts.xml")
public class PointCutAdviceTest {

	@Autowired
	private MessageService messageService;
	
	@Autowired
	private AdviceArgumentsDemo argumentsDemo;
	
	@Autowired
	private OtherMessageSender otherMessageSender;
	
	@Test
	void test() {
		messageService.send("Send Message");
		
		argumentsDemo.getLength("Hello Arguments");
		
		otherMessageSender.send(3, "Others Message");
		
		otherMessageSender.send(3);
		
		otherMessageSender.send("Others Message");
	}
	
}
