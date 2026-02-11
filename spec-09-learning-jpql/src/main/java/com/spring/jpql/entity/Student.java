package com.spring.jpql.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Student {

	private int id;
	private String name;
	private String phone;
	private String email;
}
