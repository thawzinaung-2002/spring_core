package com.spring.core.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.core.beans.MyService;

//@SpringJUnitConfig(locations = "classpath:/beans.xml")
public class XmlBeanConfigTest {

	/*
	 * @Autowired private MyService service;
	 * 
	 * @Autowired private String name2;
	 * 
	 * @Autowired private List<Integer> nums;
	 * 
	 * @Test void test() { System.out.println(service.message());
	 * System.out.println(name2); System.out.println(nums);
	 * 
	 * }
	 */
	
	
	@Test
	void test() {
		try(var context = new GenericXmlApplicationContext("classpath:/beans.xml")) {
			var service = context.getBean("service", MyService.class);
			System.out.println(service.message());
		}
	}
	
}
