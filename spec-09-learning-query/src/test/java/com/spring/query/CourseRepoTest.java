package com.spring.query;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.query.entity.repo.criteria.CourseRepoCriteria;
import com.spring.query.entity.repo.jpql.CourseRepoJPQL;

@SpringBootTest
class CourseRepoTest {

	@Autowired
	private CourseRepoCriteria criteria;

	@Autowired
	private CourseRepoJPQL jpql;

//	@Test
	void contextLoads() {

		var result1 = criteria.findAll();
		System.out.println(result1);

		var result2 = jpql.findAll();
		System.out.println(result2);

	}

//	@Test
	void findAllNameTest() {
		var result1 = criteria.findAllName();
		System.out.println(result1);

		var result2 = jpql.findAllName();
		System.out.println(result2);
	}

//	@Test
	void countAllTest() {
		var result1 = criteria.countAll();
		System.out.println(result1);

		var result2 = jpql.countAll();
		System.out.println(result2);
	}

//	@Test
	void averageTest() {
		var result1 = criteria.findAverageHours();
		System.out.println(result1);

		var result2 = jpql.findAverageHours();
		System.out.println(result2);
	}

//	@Test
	void sumTest() {
		var result1 = criteria.sumFees();
		System.out.println(result1);

		var result2 = jpql.sumFees();
		System.out.println(result2);
	}

	@Test
	void findAllDtoTest() {
		var result1 = criteria.findAllDto();
		System.out.println(result1);

		var result2 = jpql.findAllDto();
		System.out.println(result2);
	}

}
