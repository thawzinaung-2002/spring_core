package com.spring.txn.dto;

import java.math.BigDecimal;

public record TransferForm(String accountFrom, String accountTo, BigDecimal amount, String remark) {

}
