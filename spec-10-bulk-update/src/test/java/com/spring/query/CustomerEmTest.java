package com.spring.query;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.query.repo.criteria.CustomerRepoCriteria;
import com.spring.query.repo.em.CustomerRepoEm;
import com.spring.query.repo.jpql.CustomerRepoJPQL;

@SpringBootTest
class CustomerEmTest {

	@Autowired
	private CustomerRepoEm emRepo;

	@Autowired
	private CustomerRepoCriteria criteriaRepo;

	@Autowired
	private CustomerRepoJPQL jpqlRepo;

	@Disabled
	@ParameterizedTest
	@CsvSource({ "1,Mg Mg,091111111" })
	void updateTest(int id, String name, String phone) {
		emRepo.update(id, name, phone);
	}

	@Disabled
	@ParameterizedTest
	@CsvSource({ "1,Mg Mg,091111111" })
	void updateCriteriaTest(int id, String name, String phone) {
		criteriaRepo.update(id, name, phone);
	}

	@ParameterizedTest
	@CsvSource({ "1,Mg Mg,091111111" })
	void updateJpqlTest(int id, String name, String phone) {
		jpqlRepo.update(id, name, phone);
	}

}
