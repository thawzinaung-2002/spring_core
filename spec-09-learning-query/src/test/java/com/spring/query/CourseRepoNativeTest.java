package com.spring.query;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.query.entity.repo.natives.CourseRepoNative;

@SpringBootTest
public class CourseRepoNativeTest {

	@Autowired
	private CourseRepoNative nativeRepo;

	@Test
	void test() {
		var result = nativeRepo.findAll();
		System.out.println(result);

		var result2 = nativeRepo.findAllDto();
		System.out.println(result2);
	}

}
