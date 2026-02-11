package com.spring.query;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.query.entity.repo.criteria.SectionRepoCriteria;
import com.spring.query.entity.repo.jpql.SectionRepoJPQL;

@SpringBootTest
public class SectionRepoTest {

	@Autowired
	private SectionRepoCriteria criteria;
	@Autowired
	private SectionRepoJPQL jpql;

//	@Test
	void underFeesTest() {
		var result1 = criteria.searchUnderFees(2000);
		System.out.println(result1.size());

		var result2 = jpql.searchUnderFees(2000);
		System.out.println(result2.size());
	}

//	@Test
	void startAtBtweenTest() {
		var result1 = criteria.searchStartBetween(LocalDate.of(2026, 3, 1), LocalDate.of(2026, 4, 1));
		System.out.println(result1.size());

		var result2 = jpql.searchStartBetween(LocalDate.of(2026, 3, 1), LocalDate.of(2026, 4, 1));
		System.out.println(result2.size());
	}

	@Test
	void startTimeInTest() {
		List<String> times = List.of("9:00", "10:00");
		var result1 = criteria.searchStartTimeIn(times);
		System.out.println(result1.size());

		var result2 = jpql.searchStartTimeIn(times);
		System.out.println(result2.size());
	}

}
