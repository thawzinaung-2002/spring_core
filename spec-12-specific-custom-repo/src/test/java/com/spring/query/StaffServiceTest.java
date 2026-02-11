package com.spring.query;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.query.entity.Staff.Position;
import com.spring.query.service.OfficeService;

@SpringBootTest
public class StaffServiceTest {

	@Autowired
	private OfficeService service;

	@Test
	void test() {
		var result = service.searchCount(Position.Manager, null);
		System.out.println(result);
	}

}
