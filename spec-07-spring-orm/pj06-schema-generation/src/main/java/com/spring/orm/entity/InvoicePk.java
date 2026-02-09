package com.spring.orm.entity;

import java.time.LocalDate;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class InvoicePk {

	private long customerId;
	private LocalDate invoiceDate;

}
