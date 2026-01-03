package com.spring.pos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.EnumSource.Mode;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;

import com.spring.pos.data.ShoppingCartProvider;
import com.spring.pos.domain.input.ShoppingCart;

public class LearningParameterizedTest {

	@ParameterizedTest
	@NullSource
	void using_null_source(LocalDate date) {
		assertNull(date);
	}
	
	@ParameterizedTest
	@EmptySource
	void using_empty_source(List<String> list) {
		assertEquals(0, list.size());
	}
	
	@ParameterizedTest
	@NullAndEmptySource
	void using_null_and_empty(String str) {
		System.out.println(str);
	}
	
	@ParameterizedTest
	@EnumSource(value = DayOfWeek.class,
				names = {"SUNDAY", "SATURDAY"},
				mode = Mode.EXCLUDE
			)
	void using_enum_source(DayOfWeek input) {
		System.out.println(input);
	}
	
	
	@ParameterizedTest
	@MethodSource
	void using_method_source(String input) {
		System.out.println(input);
	}
	
	static Stream<String> using_method_source() {
		return Stream.iterate('A', a -> (char)(a.charValue()+1))
				.limit(5)
				.map(a -> a.toString());
	}

	
	@ParameterizedTest
	@MethodSource("com.spring.pos.data.ShoppingCartProvider#provide")
	void using_external_method_source(ShoppingCart cart) {
		System.out.println(cart);
	}
	
	@ParameterizedTest
	@ArgumentsSource(ShoppingCartProvider.class)
	void using_argument_source(ShoppingCart cart) {
		System.out.println(cart);
	}
	
}
