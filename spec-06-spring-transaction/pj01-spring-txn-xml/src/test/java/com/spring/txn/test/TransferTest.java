package com.spring.txn.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.spring.txn.dto.TransferForm;
import com.spring.txn.service.TransferService;
import com.spring.txn.test.args.TransferFormAggregator;

@SpringJUnitConfig(locations = "classpath:/application.xml")
public class TransferTest {

	@Autowired
	private TransferService service;

	@ParameterizedTest
	@CsvSource({ "001,002,50000,Test Transfer" })
	void test(@AggregateWith(TransferFormAggregator.class) TransferForm form) {
		var id = service.transfer(form);
		assertEquals(id, 1);
	}

}
