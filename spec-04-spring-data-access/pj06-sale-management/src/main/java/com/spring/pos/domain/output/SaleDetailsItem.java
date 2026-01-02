package com.spring.pos.domain.output;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class SaleDetailsItem {

	private int id;
	private String productCode;
	private String productName;
	private BigDecimal unitPrice;
	private int qty;
	
	public BigDecimal getTotal() {
		return unitPrice.multiply(BigDecimal.valueOf(qty));
	}
} 
