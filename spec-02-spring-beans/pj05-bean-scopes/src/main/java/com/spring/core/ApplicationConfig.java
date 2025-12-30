package com.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.spring.core.beans.InitializableBean;
import com.spring.core.beans.MyService;

@Configuration
public class ApplicationConfig {

	@Bean
	@Lazy
	MyService myService() {
		return new MyService();
	}
	
	
	@Bean
	@Scope("prototype")
	MyService prototypeService() {
		return new MyService();
	}
	
	
	@Bean(initMethod = "init", destroyMethod = "cleanUp")
	InitializableBean initializableBean() {
		return new InitializableBean();
	}
	
}
