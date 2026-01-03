package com.spring.pos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.pos.data.ErrorForSaleItem;
import com.spring.pos.data.SaleServiceCreateSuccess;
import com.spring.pos.data.SaleServiceFindByIdSuccess;
import com.spring.pos.data.SaleServiceFindByIdSuccess.SaleItem;
import com.spring.pos.domain.exceptions.PosBusinessException;
import com.spring.pos.domain.input.ShoppingCart;
import com.spring.pos.service.SaleService;

@SpringBootTest
@TestMethodOrder(value = OrderAnnotation.class)
public class SaleServiceTest {

	@Autowired
	private SaleService service;
	
	@ParameterizedTest
	@NullSource
	@Order(1)
	void test_error_null_cart(ShoppingCart cart) {
		var exception = assertThrows(PosBusinessException.class, 
				() -> service.checkOut(cart)
				);
		
		assertEquals(exception.getMessage(), "Cart must not be empty.");
	}
	
	@Order(2)
	@ParameterizedTest
	@MethodSource
	void test_error_empty_sale_person(ShoppingCart cart) {

		var exception = assertThrows(PosBusinessException.class, 
				() -> service.checkOut(cart)
				);
		
		assertEquals(exception.getMessage(), "Sale person must not be empty.");
	}
	
	static List<ShoppingCart> test_error_empty_sale_person() {
		return List.of(new ShoppingCart());
	}
	
	@Order(3)
	@ParameterizedTest
	@MethodSource
	void test_error_null_items(ShoppingCart cart) {
		
		var exception = assertThrows(PosBusinessException.class, 
				() -> service.checkOut(cart)
				);
		
		assertEquals(exception.getMessage(), "Please enter sale items.");
	}
	
	static List<ShoppingCart> test_error_null_items() {
		return List.of(ShoppingCart.withName("Aung Aung"));
	}
	
	@Order(4)
	@ParameterizedTest
	@ArgumentsSource(ErrorForSaleItem.class)
	void test_error_for_sale_item(ShoppingCart cart, String message) {
		var exception = assertThrows(PosBusinessException.class, 
				() -> service.checkOut(cart));
		
		assertEquals(message, exception.getMessage());
	}
	
	
	@Order(5)
	@ParameterizedTest
	@ArgumentsSource(SaleServiceCreateSuccess.class)
	void test_create_success(ShoppingCart cart, int id) {
		var result = service.checkOut(cart);
		assertEquals(result, id);
	}
	
	
	@Order(6)
	@ParameterizedTest
	@ValueSource(ints = {
			0,4
	})
	void find_by_id_not_found(int id) {
		var ex = assertThrows(PosBusinessException.class, 
				() -> service.findById(id));
		
		assertEquals("Invalid sale id.", ex.getMessage());
	}
	
	
	@Order(7)
	@ParameterizedTest
	@ArgumentsSource(SaleServiceFindByIdSuccess.class)
	void find_by_id(int id, String person, List<SaleItem> items) {
		
		var result = service.findById(id);
		
		assertNotNull(result);
		
		assertEquals(id, result.getId());
		assertEquals(person, result.getSalePerson());
		assertNotNull(result.getSaleAt());
		
		assertEquals(result.getItems().size(), items.size());
		
		for(var i=0; i<items.size(); i++) {
			var expected = items.get(i);
			var actual = result.getItems().get(i);
			
			assertEquals(id, actual.getId(), "Sale ID for index [%d] is not match.Expected [%d]: Actual [%d]".formatted(i, id, actual.getId()));
			assertEquals(expected.code(), actual.getProductCode(), "Product Code for index [%d] is not match.Expected [%d]: Actual [%d]".formatted(i, id, actual.getId()));
			assertEquals(expected.name(), actual.getProductName(), "Product Name for index [%d] is not match.Expected [%s]: Actual [%s]".formatted(i, expected.code(), actual.getProductCode()));
			assertEquals(expected.price().setScale(2), actual.getUnitPrice().setScale(2), "Product Price for index [%d] is not match.Expected [%s]: Actual [%s]".formatted(i, expected.price(), actual.getUnitPrice()));
			assertEquals(expected.quantity(), actual.getQuantity(), "Product Quantity for index [%d] is not match.Expected [%d]: Actual [%d]".formatted(i, expected.quantity(), actual.getQuantity()));
			
		}	
	}
	
	
	
	@Order(8)
	@ParameterizedTest
	@MethodSource
	void test_search(String person, LocalDate from, LocalDate to, int size) {
		
		var result = service.search(person, from, to);
		
		assertEquals(size, result.size());
	}
	
	public static Stream<Arguments> test_search() {
		return Stream.of(
					Arguments.of(null, null, null, 3),
					Arguments.of("HNT", null, null, 1),
					Arguments.of("", LocalDate.now(), null, 3),
					Arguments.of("", null, LocalDate.now(), 3),
					Arguments.of("", null, LocalDate.now().minusDays(1), 0)
				);
	}
	
}
