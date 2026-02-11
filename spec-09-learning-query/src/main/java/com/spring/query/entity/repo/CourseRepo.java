package com.spring.query.entity.repo;

import java.util.List;

import com.spring.query.entity.Course;
import com.spring.query.entity.dto.CourseDto;

public interface CourseRepo {

	List<Course> findAll();

	List<String> findAllName();

	Long countAll();

	Double findAverageHours();

	Long sumFees();

	List<CourseDto> findAllDto();

}
