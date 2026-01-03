package com.spring.simplejdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.spring.simplejdbc.domain.ProductDetails;
import com.spring.simplejdbc.domain.ProductForm;
import com.spring.simplejdbc.repo.ProductRepo;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@ActiveProfiles("jdbc")
public class ProductRepoJdbcTemplateTest {

	@Autowired
	private ProductRepo repo;
	
	@Order(1)
	@ParameterizedTest
	@CsvFileSource(resources = "/test_insert.txt", delimiter = '\t')
	void test_insert(int id, @AggregateWith(value = ProductFormAggregator.class) ProductForm form) {
		var result = repo.create(form);
		assertEquals(id, result);
	}
	
	@Order(2)
	@ParameterizedTest
	@CsvFileSource(resources = "/test_insert.txt", delimiter = '\t')
	void test_find_by_id_found(int id, @AggregateWith(value = ProductDetailsAggregator.class) ProductDetails details) {
		var result = repo.findById(id);
		assertEquals(details, result);
	}
	
	void test_find_by_id_not_found() {
		
	}
	
}
