package com.spring.jpql.entity;

import java.time.LocalDate;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class RegistrationPk {

	private int courseId;
	private LocalDate startAt;
	private int studentId;

}
