package com.spring.orm.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Tag {

	private String name;
	private int price;

}
