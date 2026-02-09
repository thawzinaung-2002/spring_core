package com.spring.orm.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Address {

	private String quarter;
	private String street;
	private String township;
	private String building;

}
