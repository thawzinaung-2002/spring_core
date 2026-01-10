package com.spring.txn.repo;

import com.spring.txn.dto.BalanceHistoryForm;

public interface BalanceHistoryRepo {

	void create(BalanceHistoryForm fromHistory);

}
