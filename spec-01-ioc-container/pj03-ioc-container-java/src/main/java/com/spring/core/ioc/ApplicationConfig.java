package com.spring.core.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.spring.core.ioc.beans")
public class ApplicationConfig {

	@Bean
	HelloBean helloBean() {
		return new HelloBean();
	}
	
}
