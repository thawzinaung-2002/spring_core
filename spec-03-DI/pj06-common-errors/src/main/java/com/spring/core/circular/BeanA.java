package com.spring.core.circular;

import org.springframework.stereotype.Component;

@Component
public class BeanA {
	
	private BeanB bean;

	public BeanA(BeanB bean) {
		super();
		this.bean = bean;
	}

	
	
}
