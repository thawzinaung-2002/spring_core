package com.spring.pos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.pos.domain.exceptions.PosBusinessException;
import com.spring.pos.service.ProductService;

@SpringBootTest
public class ProductServiceTest {

	@Autowired
	private ProductService service;
	
	void test_error_no_code() {
		var exception = assertThrows(PosBusinessException.class, 
				() -> service.findByCode(null));
		
		assertEquals(exception.getMessage(), "Please enter product code.");
	}
	
	@ParameterizedTest
	@ValueSource(strings = {
			"p0001",
			"P0000"
	})
	void test_error_invalid_code(String code) {
		
		var exception = assertThrows(PosBusinessException.class, 
				() -> service.findByCode(code));
		
		assertEquals(exception.getMessage(), "Invalid product code.");
	}
	
	
	@ParameterizedTest
	@CsvSource({
		"P0001,Egg L Size, 500",
		"P0002,Egg M Size, 400",
		"P0003,Egg S Size, 350",
		"P0004,Potato Chips, 1500",
		"P0005,Coke 300ML,1000",
		"P0006,Coke 600ML, 2000"
	})
	void test_found(String code, String name, BigDecimal price) {
		var result = service.findByCode(code);
		
		assertNotNull(result);
		
		assertEquals(result.getCode(), code);
		assertEquals(result.getName(), name);
		assertEquals(result.getPrice().setScale(2), price.setScale(2));
		
	}
	
}
