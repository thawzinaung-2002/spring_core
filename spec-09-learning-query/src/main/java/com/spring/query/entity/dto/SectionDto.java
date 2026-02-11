package com.spring.query.entity.dto;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import com.spring.query.entity.Course_;
import com.spring.query.entity.Section;
import com.spring.query.entity.SectionPk;
import com.spring.query.entity.Section_;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public record SectionDto(SectionPk id, int hours, LocalDate endAt, String startTime, String endTime, String courseName,
		int fees, List<DayOfWeek> days) {

	public static void select(CriteriaQuery<SectionDto> cq, Root<Section> root) {
		cq.multiselect(root.get(Section_.pk), root.get(Section_.course).get(Course_.hours), root.get(Section_.endAt),
				root.get(Section_.startTime), root.get(Section_.endTime), root.get(Section_.course).get(Course_.name),
				root.get(Section_.fees), root.get(Section_.days));
	}

}
