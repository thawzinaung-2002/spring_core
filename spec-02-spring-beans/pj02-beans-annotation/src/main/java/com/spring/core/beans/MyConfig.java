package com.spring.core.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

	@Bean
	String hello() {
		return "Hello Java";
	}
	
}
