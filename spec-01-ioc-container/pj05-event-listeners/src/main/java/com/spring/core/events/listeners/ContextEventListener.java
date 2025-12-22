package com.spring.core.events.listeners;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.spring.core.events.MyEvent;

@Component
public class ContextEventListener {

	@EventListener
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println(event.getClass().getName());
	}

	@EventListener
	public void myEventListen(MyEvent event) {
		System.out.println(event);
	}
	
}
