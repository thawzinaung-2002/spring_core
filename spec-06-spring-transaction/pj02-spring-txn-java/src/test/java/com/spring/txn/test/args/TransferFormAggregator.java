package com.spring.txn.test.args;

import java.math.BigDecimal;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;

import com.spring.txn.dto.TransferForm;

public class TransferFormAggregator implements ArgumentsAggregator {

	@Override
	public Object aggregateArguments(ArgumentsAccessor accessor, ParameterContext context)
			throws ArgumentsAggregationException {
		return new TransferForm(accessor.getString(0), accessor.getString(1), BigDecimal.valueOf(accessor.getDouble(2)),
				accessor.getString(3));
	}

}
