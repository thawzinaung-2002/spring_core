package com.spring.txn.repo;

import java.util.Optional;

import com.spring.txn.dto.AccountInfo;
import com.spring.txn.dto.AmountUpdateForm;

public interface AccountRepo {

	Optional<AccountInfo> findByAccountId(String accountNum);

	void updateAmount(AmountUpdateForm fromAmountForm);

}
