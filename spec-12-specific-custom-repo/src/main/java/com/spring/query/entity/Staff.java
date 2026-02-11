package com.spring.query.entity;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Staff {

	@Id
	private UUID id;

	@MapsId
	@OneToOne(optional = false)
	private Account account;

	private LocalDate entryAt;
	private LocalDate retiredAt;
	private Position position;

	public enum Position {
		Employee, Supervisor, Manager
	}
}
