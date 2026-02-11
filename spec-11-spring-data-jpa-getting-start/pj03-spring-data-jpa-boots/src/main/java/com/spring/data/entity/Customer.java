package com.spring.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQuery;
import lombok.Data;

@Data
@Entity
@NamedQuery(name = "Customer.findByKeyword", query = """
		select c from Customer c where c.name like ?1
		or c.phone like ?1 or c.email like ?1
		""")
@NamedNativeQuery(name = "Customer.search", query = """
		select * from customer c where c.name like ?1
		or c.phone like ?1 or c.email like ?1
		""", resultClass = Customer.class)
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private String phone;
	private String email;

}
