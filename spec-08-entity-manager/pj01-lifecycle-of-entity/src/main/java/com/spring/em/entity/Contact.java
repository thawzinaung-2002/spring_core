package com.spring.em.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Contact {

	@Id
	private int id;
	private String phone;
	private String email;

	@MapsId
	@OneToOne(optional = false)
	private Teacher teacher;
}
