package com.spring.data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import com.spring.data.repo.CustomerRepo;

@SpringBootTest
@Sql(scripts = "/users.sql", executionPhase = ExecutionPhase.BEFORE_TEST_CLASS)
public class ProjectingTest {

	@Autowired
	private CustomerRepo repo;

//	@Test
	void test() {
		var result = repo.findNameByPhoneStartsWith("555");
		System.out.println(result);
	}

//	@Test
	void test2() {
		var result = repo.findIdAndNameByEmailLike("user2@example.com");
		System.out.println(result);
		System.out.println(result.getLongName());
	}

	@Test
	void test3() {
		var result = repo.findIdNamePhoneByEmailLike("user2@example.com");
		System.out.println(result);
	}

}
