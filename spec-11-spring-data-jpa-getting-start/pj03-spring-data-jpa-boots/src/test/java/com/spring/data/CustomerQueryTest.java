package com.spring.data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import com.spring.data.repo.CustomerRepo;

@SpringBootTest
@Sql(scripts = "/users.sql", executionPhase = ExecutionPhase.BEFORE_TEST_CLASS)
public class CustomerQueryTest {

	@Autowired
	private CustomerRepo repo;

//	@Test
	void test() {

		var result = repo.findByNameLike("Aung Aung");
		System.out.println(result);

		var result2 = repo.findByKeyword("Aung Aung");
		System.out.println(result2);

	}

//	@Test
	void test2() {
		var result = repo.search("Aung Aung");
		System.out.println(result);
	}

	@Test
	void test3() {
		var result = repo.findByKeyword2("Aung Aung");
		System.out.println(result);
	}
}
