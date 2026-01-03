package com.spring.simplejdbc;

import java.math.BigDecimal;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;

import com.spring.simplejdbc.domain.ProductDetails;

public class ProductDetailsAggregator implements ArgumentsAggregator{

	@Override
	public Object aggregateArguments(ArgumentsAccessor accessor, ParameterContext context)
			throws ArgumentsAggregationException {
		return new ProductDetails(accessor.getInteger(0) ,accessor.getString(1), accessor.getString(2), accessor.getString(3), 
				BigDecimal.valueOf(Double.parseDouble(accessor.getString(4))));
	}

}
