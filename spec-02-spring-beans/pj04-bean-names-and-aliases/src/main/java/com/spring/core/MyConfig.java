package com.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.spring.core.beans.MyService;
import com.spring.core.beans.MyServiceOne;

@Configuration
@ComponentScan(basePackages = "com.spring.core.beans")
public class MyConfig {

	@Bean({
		"default",
		"aliasone"
	})
	MyService myService() {
		return new MyServiceOne();
	}
	
}
