package com.spring.txn.dto;

import java.math.BigDecimal;

public record BalanceHistoryForm(String accountNum, int version, BigDecimal lastAmount, int trxId, boolean debit,
		BigDecimal trx_amount, String remark) {

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private String accountNum;
		private int version;
		private BigDecimal lastAmount;
		private int trxId;
		private boolean debit;
		private BigDecimal trx_amount;
		private String remark;

		public BalanceHistoryForm build() {
			return new BalanceHistoryForm(accountNum, version, lastAmount, trxId, debit, trx_amount, remark);
		}

		public Builder accountNum(String accountNum) {
			this.accountNum = accountNum;
			return this;
		}

		public Builder nextVersion(int version) {
			this.version = version;
			return this;
		}

		public Builder lastAmount(BigDecimal lastAmount) {
			this.lastAmount = lastAmount;
			return this;
		}

		public Builder trxId(int trxId) {
			this.trxId = trxId;
			return this;
		}

		public Builder isDebit(boolean debit) {
			this.debit = debit;
			return this;
		}

		public Builder trxAmount(BigDecimal amount) {
			this.trx_amount = amount;
			return this;
		}

		public Builder remark(String remark) {
			this.remark = remark;
			return this;
		}

	}

}
