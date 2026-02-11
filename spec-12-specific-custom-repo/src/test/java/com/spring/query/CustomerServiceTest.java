package com.spring.query;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.query.dto.input.CustomerSearch;
import com.spring.query.entity.Customer.Gender;
import com.spring.query.service.CustomerService;

@SpringBootTest
class CustomerServiceTest {

	@Autowired
	private CustomerService service;

	@Test
	void contextLoads() {

		var result = service.searchBySpecification(new CustomerSearch("Aung Aung", null, null, Gender.Female));

		System.out.println(result);
	}

}
