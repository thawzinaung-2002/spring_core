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
public class Customer {

	@Id
	private UUID id;

	@MapsId
	@OneToOne
	private Account account;

	private String name;
	private String phone;
	private String email;
	private LocalDate dob;
	private Gender gender;

	public enum Gender {
		Male, Female
	}

}
