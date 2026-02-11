package com.spring.jpql.entity;

import java.time.LocalDateTime;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Registration {

	@EmbeddedId
	private RegistrationPk id;

	private Student student;
	private Section section;
	private LocalDateTime registeredAt;

}
