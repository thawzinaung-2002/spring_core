package com.spring.jpql.entity;

import java.time.LocalDate;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class SessionPk {

	private int id;
	private LocalDate startAt;

}
