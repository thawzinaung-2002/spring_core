package com.spring.core.events;

import java.time.LocalDateTime;

public record MyEvent (String name, LocalDateTime date){
	
	public MyEvent(String name) {
		this(name, LocalDateTime.now());
	}
}
