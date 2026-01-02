package com.spring.pos.domain.output;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductDto {

	private String code;
	private String name;
	private BigDecimal price;
	
}
