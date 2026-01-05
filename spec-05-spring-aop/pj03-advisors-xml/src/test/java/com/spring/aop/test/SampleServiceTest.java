package com.spring.aop.test;

import java.time.DayOfWeek;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.spring.aop.service.CommonService;

@SpringJUnitConfig(locations = "classpath:/application.xml")
public class SampleServiceTest {

	@Autowired
	private CommonService service;
	
	@Test
	void test() {
		service.show(1, "HNT", DayOfWeek.SATURDAY);
		service.showWithLog(2, "TZA", DayOfWeek.SUNDAY);
	}
	
}
