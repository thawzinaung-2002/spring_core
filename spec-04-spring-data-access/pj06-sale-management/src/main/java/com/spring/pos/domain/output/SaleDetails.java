package com.spring.pos.domain.output;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class SaleDetails {

	private int id;
	private String salePerson;
	private LocalDateTime saleAt;
	private List<SaleDetailsItem> items;

	public int getItemCount() {
		if (null != items && !items.isEmpty()) {
			return items.stream().mapToInt(i -> i.getQty()).sum();
		}
		return 0;
	}

	public BigDecimal getTotal() {
		if (null != items && !items.isEmpty()) {
			return items.stream().map(i -> i.getTotal()).reduce(BigDecimal.ZERO, BigDecimal::add);
		}
		return BigDecimal.ZERO;
	}

	public static SaleDetails from(SaleInfo saleInfo, List<SaleDetailsItem> items2) {
		var saleDetails = new SaleDetails();
		saleDetails.setId(saleInfo.getId());
		saleDetails.setSaleAt(saleInfo.getSaleAt());
		saleDetails.setSalePerson(saleInfo.getSalePerson());
		saleDetails.setItems(items2);
		return saleDetails;
	}
}
