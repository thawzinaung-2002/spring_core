package com.spring.pos.data;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import com.spring.pos.domain.input.SaleItem;
import com.spring.pos.domain.input.ShoppingCart;

public class SaleServiceCreateSuccess implements ArgumentsProvider{

	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
				
		return Stream.of(
				Arguments.of(getCart("TZA", List.of(new CartItem("P0001", BigDecimal.valueOf(500), 3))), 1),
				
				Arguments.of(getCart("HNT", List.of(
						new CartItem("P0001", BigDecimal.valueOf(500), 2),
						new CartItem("P0002", BigDecimal.valueOf(400), 2))), 2),
				
				Arguments.of(getCart("Nilar", List.of(new CartItem("P0006", BigDecimal.valueOf(500), 3))), 3)
				);
	}
	
	private ShoppingCart getCart(String person, List<CartItem> items) {
		var cart = new ShoppingCart();
		cart.setSalePerson(person);
		cart.setItems(items.stream().map(CartItem::getItem).toList());
		return cart;
	}

	private static record CartItem(
			String code,
			BigDecimal price,
			int quantity
			) {
		
		SaleItem getItem() {
			var item = new SaleItem();
			item.setProductCode(code);
			item.setQuantity(quantity);
			item.setUnitPrice(price);
			return item;
		}
	}
	
}
