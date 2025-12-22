package com.spring.core.processors;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import com.spring.core.beans.MyBean;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor{

	@Override
	public @Nullable Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		
		if(bean instanceof MyBean myBean) {
			myBean.setValue("Hello Bean Post Processor Value Changed!");
		}
		
		return bean;
	}
	
}
