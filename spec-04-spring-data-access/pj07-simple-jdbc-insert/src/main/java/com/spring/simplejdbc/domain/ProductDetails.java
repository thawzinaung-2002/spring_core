package com.spring.simplejdbc.domain;

import java.math.BigDecimal;

public record ProductDetails(
		int id,
		String name,
		String category,
		String image,
		BigDecimal price
		) {

	public ProductDetails {
		if(price != null) {
			price = price.setScale(2);
		}
	}
	
}
