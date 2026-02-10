package com.spring.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.demo.entity.Address;
import com.spring.demo.entity.Student;
import com.spring.demo.repo.StudentRepo;

@SpringBootTest
public class ListenerTest {

	@Autowired
	private StudentRepo repo;

	@Test
	void test() {

		var student = new Student();
		var address = new Address();

		address.setBuilding("No 120B/F");
		address.setQuarter("32 Ward");
		address.setStreet("Thitsar");
		address.setTownship("Yangon");

		student.setAddress(address);
		student.setName("Thaw Zin Aung");

		repo.create(student);

		student.setName("Aung Aung");
		address.setStreet("No-161");

		repo.update(student);

	}

}
