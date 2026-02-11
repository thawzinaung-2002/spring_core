package com.spring.jpql.entity;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Section {

	@EmbeddedId
	private SectionPk pk;

	private Course course;

	private List<DayOfWeek> days;
	private String startTime;
	private String endTime;
	private LocalDate endAt;
	private int fees;

}
