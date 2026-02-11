package com.spring.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDto {

	private int id;
	private String name;
	private String phone;

}
