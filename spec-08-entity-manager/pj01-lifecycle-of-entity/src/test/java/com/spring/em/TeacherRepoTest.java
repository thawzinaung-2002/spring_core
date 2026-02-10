package com.spring.em;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.em.entity.Contact;
import com.spring.em.entity.Teacher;
import com.spring.em.repo.TeacherEntityDemo;
import com.spring.em.repo.TeacherRepo;

@SpringBootTest
public class TeacherRepoTest {

	@Autowired
	private TeacherRepo repo;

	@Autowired
	private TeacherEntityDemo demo;

	@Test
	public void entityTest() {
		demo.demo();
	}

//	@Test
	public void test() {
		var teacher = new Teacher();
		teacher.setName("Daw Mya");

		var contact = new Contact();
		contact.setPhone("09231235632");
		contact.setEmail("mya@gmail.com");
		contact.setTeacher(teacher);

		teacher.setContact(contact);

		repo.create(teacher);
	}

}
