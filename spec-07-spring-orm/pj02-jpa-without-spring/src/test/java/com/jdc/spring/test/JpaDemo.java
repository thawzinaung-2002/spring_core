package com.jdc.spring.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.provider.CsvSource;

import com.spring.orm.entity.Account;

import jakarta.persistence.Persistence;

public class JpaDemo {

	@ParameterizedTest
	@CsvSource({ "C001,Thida,09779580179,thidar@gmail.com" })
	void createAccount(@AggregateWith(AccountArgument.class) Account account) {

		var emf = Persistence.createEntityManagerFactory("pj02-jpa-without-spring");
		var em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(account);
		em.getTransaction().commit();
	}

}
