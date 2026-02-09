package com.spring.orm.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Invoice {

	@EmbeddedId
	private InvoicePk id;

	private LocalDateTime invoiceAt;

	private LocalDate dueDate;

	private double amount;

}
