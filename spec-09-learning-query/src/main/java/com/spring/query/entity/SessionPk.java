package com.spring.query.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class SessionPk {

	@Column(name = "course_id")
	private int courseId;

	@Column(name = "start_at")
	private LocalDate startAt;

}
