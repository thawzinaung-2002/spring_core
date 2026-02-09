package com.spring.orm.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(indexes = { @Index(columnList = "name"), @Index(columnList = "shopName"), })
@EqualsAndHashCode(callSuper = false)
public class Merchant extends SecurityInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(nullable = false)
	private String name;

	private String position;

	@Column(nullable = false)
	private String shopName;

	@ManyToMany
	private List<Product> products;

}
