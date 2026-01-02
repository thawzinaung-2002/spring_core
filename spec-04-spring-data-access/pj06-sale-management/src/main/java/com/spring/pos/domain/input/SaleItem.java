package com.spring.pos.domain.input;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class SaleItem {

	private String productCode;
	private int qty;
	private BigDecimal unitPrice;
	
}
