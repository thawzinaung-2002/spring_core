package com.spring.simplejdbc.domain;

import java.math.BigDecimal;

public record ProductForm(
		String name,
		String category,
		String image,
		BigDecimal price
		) {

}
