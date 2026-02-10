package com.spring.em;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.em.repo.StudentEntityDemoRepo;

@SpringBootTest
public class StudentDemoTest {

	@Autowired
	private StudentEntityDemoRepo demoRepo;

	@Test
	void test() {
		demoRepo.demo();
	}

}
