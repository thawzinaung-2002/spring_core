package com.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.core.autowired.MyClient;
import com.spring.core.autowired.MyService;

@Configuration
public class MyConfiguration {

	@Bean
	MyService myService() {
		return new MyService();
	}
	
	@Bean
	MyClient myClient() {
		return new MyClient();
	}
	
}
