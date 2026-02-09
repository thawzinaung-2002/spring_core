package com.spring.orm.entity;

import java.util.Date;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.TableGenerator;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
@TableGenerator(name = "customer_seq", allocationSize = 1)
public class Customer {

	@Id
	@GeneratedValue(generator = "customer_seq")
	private long id;

	private String name;

	private String phone;

	@Basic(optional = true)
	@Temporal(TemporalType.DATE)
	private Date dob;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Lob
	private String remark;

	private Address address;

	public enum Gender {
		Male, Female
	}
}
