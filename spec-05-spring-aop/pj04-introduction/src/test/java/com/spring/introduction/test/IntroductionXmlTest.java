package com.spring.introduction.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.spring.introduction.ExtraFunctions;
import com.spring.introduction.MyService;

@SpringJUnitConfig(locations = "classpath:/application.xml")
public class IntroductionXmlTest {

	@Autowired
	private MyService service;

	@Test
	void test() {
		service.send("Hello Introduction");
		if (service instanceof ExtraFunctions ef) {
			ef.logTime();
		}
	}

}
