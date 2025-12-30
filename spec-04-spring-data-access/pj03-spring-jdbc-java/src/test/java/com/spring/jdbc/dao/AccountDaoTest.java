package com.spring.jdbc.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.spring.jdbc.ApplicationConfig;
import com.spring.jdbc.dto.AccountForm;

@SpringJUnitConfig(classes = ApplicationConfig.class)
@TestMethodOrder(OrderAnnotation.class)
public class AccountDaoTest {


	@Autowired
	private AccountDao dao;

	
	@Order(1)
	@ParameterizedTest
	@CsvSource({
		"Aung Aung,09779580179,1",
		"Hla Hla,09769580177,2",
		"Ba Maung,09729580189,3",
	})
	void test_insert(String name, String phone, int expectedId) {
		
		var form = new AccountForm(name, phone);
		var id = dao.create(form);
		assertEquals(expectedId, id);
	}
	
	@Test
	@Order(2)
	void test_select_count() {
		var count = dao.count();
		assertEquals(3, count);
	}
	
	
	@Order(3)
	@ParameterizedTest
	@CsvSource({
		"Aung Aung,09779580179,1",
		"Hla Hla,09769580177,2",
		"Ba Maung,09729580189,3",
	})
	void test_find_by_id(String name, String phone, int id) {
		
		var dto = dao.findById(id);
		assertEquals(dto.name(), name);
		assertEquals(dto.phone(), phone);
		
	}
	
	
	@Order(4)
	@ParameterizedTest
	@ValueSource(ints = {0, 4, 5})
	void test_find_by_id_notfound(int id) {
		
		var dto = dao.findById(id);
		assertNull(dto);
		
	}

	
}
