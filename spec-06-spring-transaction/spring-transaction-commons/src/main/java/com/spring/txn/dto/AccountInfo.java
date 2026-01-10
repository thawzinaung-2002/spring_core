package com.spring.txn.dto;

import java.math.BigDecimal;

public record AccountInfo(String accountNum, String accountName, String phone, BigDecimal amount, int version) {

	public int nextVersion() {
		return version + 1;
	}

}
