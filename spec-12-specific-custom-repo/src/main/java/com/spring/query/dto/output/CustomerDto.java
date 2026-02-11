package com.spring.query.dto.output;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import com.spring.query.entity.Account_;
import com.spring.query.entity.Customer;
import com.spring.query.entity.Customer.Gender;
import com.spring.query.entity.Customer_;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public record CustomerDto(UUID id, String loginId, String name, String phone, String email, LocalDate dob,
		Gender gender, LocalDateTime activatedAt, LocalDateTime expiredAt) {

	public static void select(CriteriaQuery<CustomerDto> cq, Root<Customer> root) {
		cq.multiselect(root.get(Customer_.id), root.get(Customer_.account).get(Account_.loginId),
				root.get(Customer_.name), root.get(Customer_.phone), root.get(Customer_.email), root.get(Customer_.dob),
				root.get(Customer_.gender), root.get(Customer_.account).get(Account_.activatedAt),
				root.get(Customer_.account).get(Account_.expiredAt));
	}

	public static CustomerDto from(Customer customer) {
		return new CustomerDto(customer.getId(), customer.getAccount().getLoginId(), customer.getName(),
				customer.getPhone(), customer.getEmail(), customer.getDob(), customer.getGender(),
				customer.getAccount().getActivatedAt(), customer.getAccount().getExpiredAt());
	}
}
