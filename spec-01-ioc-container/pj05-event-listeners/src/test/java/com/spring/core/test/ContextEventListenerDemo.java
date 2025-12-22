package com.spring.core.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.core.events.ApplicationConfig;
import com.spring.core.events.MyEvent;
import com.spring.core.events.publisher.MyEventPublisher;

public class ContextEventListenerDemo {

	@Test
	void demo() {
		
		try(var context = new AnnotationConfigApplicationContext(ApplicationConfig.class)) {
			
			var publisher = context.getBean(MyEventPublisher.class);
			publisher.publish(new MyEvent("First Event"));
			publisher.publish(new MyEvent("Second Event"));
			
		}
		
	}
	
}
