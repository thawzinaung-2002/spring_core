package com.spring.introduction.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.spring.AppConfig;
import com.spring.introduction.ExtraFunctions;
import com.spring.introduction.MyService;

@SpringJUnitConfig(classes = AppConfig.class)
public class IntroductionJavaTest {

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
