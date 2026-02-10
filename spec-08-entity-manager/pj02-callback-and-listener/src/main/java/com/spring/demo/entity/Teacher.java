package com.spring.demo.entity;

import com.spring.demo.entity.listener.AbstractEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Teacher extends AbstractEntity {

	@Id
	private int id;
	private String name;
	private String phone;
	private String email;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Address address;

}
