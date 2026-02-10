package com.spring.em;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.em.entity.Student;
import com.spring.em.repo.StudentRepo;

@SpringBootTest
@TestMethodOrder(value = OrderAnnotation.class)
public class StudentRepoTest {

	@Autowired
	private StudentRepo repo;

	@Order(1)
	@ParameterizedTest
	@CsvSource({ "Thaw Zin,09779580179", "Aung Aung,09779580133" })
	void testCreate(String name, String phone) {
		var entity = new Student();
		entity.setName(name);
		entity.setPhone(phone);
		repo.create(entity);
	}

	@Order(2)
	@ParameterizedTest
	@CsvSource({ "1,U Thaw Zin,09779580179", "2,U Aung Aung,09779580133" })
	void testUpdate(int id, String name, String phone) {
		var entity = repo.update(id, name, phone);
		assertEquals(entity.getName(), name);
		assertEquals(entity.getPhone(), phone);
	}

	@Order(3)
	@ParameterizedTest
	@ValueSource(ints = 1)
	void testDelete(int id) {
		repo.delete(id);
		var entity = repo.findById(id);
		assertNull(entity);
	}

}
