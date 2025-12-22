package com.spring.core.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.core.beans.MyBean;

public class PostProcessorDemon {

	@Test
	void demo() {
		
		try(var context=new GenericXmlApplicationContext("classpath:/application.xml")) {
		
			var myBean = context.getBean(MyBean.class);
			
			System.out.println(myBean.getValue());
			
		}
		
	}
	
}
