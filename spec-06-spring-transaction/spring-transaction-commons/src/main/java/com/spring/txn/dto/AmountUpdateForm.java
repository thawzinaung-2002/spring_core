package com.spring.txn.dto;

import java.math.BigDecimal;

public record AmountUpdateForm(String accountNum, BigDecimal amount, int version) {

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private String accountNum;
		private BigDecimal amount;
		private int version;

		public AmountUpdateForm build() {
			return new AmountUpdateForm(accountNum, amount, version);
		}

		public Builder accountNum(String accountNum) {
			this.accountNum = accountNum;
			return this;
		}

		public Builder updatedAmount(BigDecimal amount) {
			this.amount = amount;
			return this;
		}

		public Builder nextVersion(int version) {
			this.version = version;
			return this;
		}

	}

}
