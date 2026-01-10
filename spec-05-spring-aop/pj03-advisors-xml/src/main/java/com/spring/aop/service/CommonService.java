package com.spring.aop.service;

import java.time.DayOfWeek;

import org.springframework.stereotype.Service;

import com.spring.aop.advisor.OnMethod;

@Service
public class CommonService {

	public void show(int id, String name, DayOfWeek day) {
		System.out.printf("SampleService#show id: %s%n", id);
		System.out.printf("SampleService#show name: %s%n", name);
		System.out.printf("SampleService#show day: %s%n%n", day);
	}
	
	@OnMethod
	public void showWithLog(int id, String name, DayOfWeek day) {
		System.out.printf("SampleService#showWithLog id: %s%n", id);
		System.out.printf("SampleService#showWithLog name: %s%n", name);
		System.out.printf("SampleService#showWithLog day: %s%n%n", day);
	}
	
}
