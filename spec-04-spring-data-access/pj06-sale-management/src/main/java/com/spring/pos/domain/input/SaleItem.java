package com.spring.pos.domain.input;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class SaleItem {

	private int saleId;
	private String productCode;
	private int quantity;
	private BigDecimal unitPrice;
	
}
