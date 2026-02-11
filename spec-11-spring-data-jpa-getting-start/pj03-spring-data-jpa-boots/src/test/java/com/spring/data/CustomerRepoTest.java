package com.spring.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.data.entity.Customer;
import com.spring.data.repo.CustomerRepo;

@SpringBootTest
@TestMethodOrder(value = OrderAnnotation.class)
public class CustomerRepoTest {

	@Autowired
	private CustomerRepo repo;

	@Order(1)
	@ParameterizedTest
	@CsvSource({ "1,Aung Aung,09779580179,thawzin@gmail.com" })
	void test(int id, String name, String phone, String email) {
		var customer = new Customer();
		customer.setName(name);
		customer.setPhone(phone);
		customer.setEmail(email);
		customer = repo.save(customer);
		assertEquals(id, customer.getId());
	}

	@Order(2)
	@ParameterizedTest
	@CsvSource({ "1,Aung Aung,09779580179,thawzin@gmail.com" })
	void findByIdTest(int id, String name, String phone, String email) {
		var result = repo.findById(id);
		assertTrue(result.isPresent());

		var entity = result.get();
		assertEquals(name, entity.getName());
		assertEquals(phone, entity.getPhone());
		assertEquals(email, entity.getEmail());
	}

}
