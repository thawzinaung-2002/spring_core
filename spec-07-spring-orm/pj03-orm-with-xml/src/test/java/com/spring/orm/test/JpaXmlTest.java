package com.spring.orm.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.spring.orm.entity.Account;
import com.spring.orm.entity.repo.AccountRepo;

@SpringJUnitConfig(locations = "classpath:/application.xml")
public class JpaXmlTest {

	@Autowired
	private AccountRepo accountRepo;

	@ParameterizedTest
	@CsvSource({ "C001,Thida,09779580179,thidar@gmail.com" })
	void createAccount(@AggregateWith(AccountArgument.class) Account account) {

		accountRepo.create(account);
	}

}
