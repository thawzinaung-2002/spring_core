package com.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.spring.core.autowired.MyClient;

@Configuration
@ComponentScan(basePackages = "com.spring.core.autowired")
public class MyConfiguration {

//	@Bean
////	@Qualifier("s1")
//	@Order(1)
//	MyService service1() {
//		return new MyService1();
//	}
//	
//	@Bean
////	@Qualifier("s2")
//	@Order(2)
//	MyService service2() {
//		return new MyService1();
//	}
//	
//	@Bean
////	@Primary
//	@Order(3)
//	MyService service3() {
//		return new MyService1();
//	}
	
	@Bean
	MyClient myClient() {
		return new MyClient();
	}
	
}
