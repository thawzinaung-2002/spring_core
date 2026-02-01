package com.spring.orm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Account {

	@Id
	private String code;
	private String name;
	private String phone;
	private String email;

}
