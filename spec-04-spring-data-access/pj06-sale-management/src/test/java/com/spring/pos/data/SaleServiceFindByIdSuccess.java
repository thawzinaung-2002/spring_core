package com.spring.pos.data;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class SaleServiceFindByIdSuccess implements ArgumentsProvider{

	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
		return Stream.of(
					Arguments.of(1, "TZA", List.of(
							new SaleItem("P0001", "Egg L Size", BigDecimal.valueOf(500), 3)
							)),
					
					Arguments.of(2, "HNT", List.of(
							new SaleItem("P0001", "Egg L Size", BigDecimal.valueOf(500), 2),
							new SaleItem("P0002", "Egg M Size", BigDecimal.valueOf(400), 2)
							)),
					
					Arguments.of(3, "Nilar", List.of(
							new SaleItem("P0006", "Coke 600ML", BigDecimal.valueOf(500), 3)
							))
					
				);
	}


	public static record SaleItem(
			String code,
			String name,
			BigDecimal price,
			int quantity
			) {
		
	}

}
