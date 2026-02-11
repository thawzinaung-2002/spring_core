package com.spring.query.entity;

import com.spring.query.entity.dto.CourseDto;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SqlResultSetMapping;
import lombok.Data;

@Data
@Entity
@NamedQuery(name = "Course.findAll", query = "select c from Course c ")
@NamedQuery(name = "Course.findAllNames", query = "select c.name from Course c ")
@NamedQuery(name = "Course.countAll", query = "select count(c.id) from Course c ")
@NamedQuery(name = "Course.findAverageHours", query = "select avg(c.hours) from Course c ")
@NamedQuery(name = "Course.findSumFees", query = "select sum(c.fees) from Course c ")
@NamedQuery(name = "Course.findAllDto", query = "select new com.spring.query.entity.dto.CourseDto(c.id, c.name, c.fees) from Course c ")

@NamedNativeQuery(name = "Course.findAllNative", query = "select * from course", resultClass = Course.class)
@NamedNativeQuery(name = "Course.findAllDtoNative", query = "select id,name,fees from course", resultSetMapping = "native.dto")
@SqlResultSetMapping(name = "native.dto", classes = @ConstructorResult(targetClass = CourseDto.class, columns = {
		@ColumnResult(name = "id"), @ColumnResult(name = "name"), @ColumnResult(name = "fees") }

))
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int hours;
	private int fees;

}
