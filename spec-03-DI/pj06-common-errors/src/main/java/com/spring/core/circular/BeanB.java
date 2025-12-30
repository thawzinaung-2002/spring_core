package com.spring.core.circular;

import org.springframework.stereotype.Component;

@Component
public class BeanB {

	private BeanC bean;

	public BeanB(BeanC bean) {
		super();
		this.bean = bean;
	}
	
	
	
}
