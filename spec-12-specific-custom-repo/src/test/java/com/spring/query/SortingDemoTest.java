package com.spring.query;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import com.spring.query.entity.Account;
import com.spring.query.entity.Customer;
import com.spring.query.entity.Customer_;
import com.spring.query.repo.CustomerRepo;

@SpringBootTest
public class SortingDemoTest {

	@Autowired
	private CustomerRepo customerRepo;

//	@Test
	void test() {

		customerRepo.findAll(Sort.by(Customer_.NAME));
	}

	@Test
	void test2() {

		var typedSort = Sort.sort(Customer.class);
		var activatedAtSort = typedSort.by(Customer::getAccount).by(Account::getActivatedAt).descending();
		var nameDesc = typedSort.by(Customer::getName).ascending();

		customerRepo.findAll(activatedAtSort.and(nameDesc));

	}

}
