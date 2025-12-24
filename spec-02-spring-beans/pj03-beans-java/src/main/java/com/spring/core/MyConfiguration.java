package com.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.core.beans.MyService;

@Configuration
public class MyConfiguration {

	@Bean
	String hello() {
		return "Hello Java";
	}
	
	@Bean
	MyService service(String str) {
		return new MyService();
	}
	
}
