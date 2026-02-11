package com.spring.query.entity;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Convert;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import lombok.Data;

@Data
@Entity
@NamedQuery(name = "Section.searchUnderFees", query = """
		select new com.spring.query.entity.dto.SectionDto(c.pk, c.course.hours, c.endAt, c.startTime, c.endTime,
		c.course.name, c.fees, c.days)
		from Section c where c.fees <=: fees
		""")
@NamedQuery(name = "Section.searchStartBetween", query = """
		select new com.spring.query.entity.dto.SectionDto(c.pk, c.course.hours, c.endAt, c.startTime, c.endTime,
		c.course.name, c.fees, c.days)
		from Section c where c.pk.startAt between :from and :to
		""")
@NamedQuery(name = "Section.searchStartTimeIn", query = """
		select new com.spring.query.entity.dto.SectionDto(c.pk, c.course.hours, c.endAt, c.startTime, c.endTime,
		c.course.name, c.fees, c.days)
		from Section c where c.startTime in :times
		""")
public class Section {

	@EmbeddedId
	private SectionPk pk;

	@ManyToOne(optional = false)
	@JoinColumn(name = "course_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Course course;

	@Convert(converter = DaysConverter.class)
	private List<DayOfWeek> days;

	private String startTime;
	private String endTime;
	private LocalDate endAt;
	private int fees;

}
