package com.spring.txn.repo;

import com.spring.txn.dto.TransferForm;

public interface TransferRepo {

	int initiate(TransferForm form);

	void updateStatus(int trxId, String string);

}
