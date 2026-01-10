package com.spring.txn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.txn.dto.AmountUpdateForm;
import com.spring.txn.dto.BalanceHistoryForm;
import com.spring.txn.dto.TransferForm;
import com.spring.txn.exception.BusinessException;
import com.spring.txn.repo.AccountRepo;
import com.spring.txn.repo.BalanceHistoryRepo;
import com.spring.txn.repo.TransferRepo;

@Service
public class TransferServiceImpl implements TransferService {

	@Autowired
	private AccountRepo accountRepo;

	@Autowired
	private BalanceHistoryRepo historyRepo;

	@Autowired
	private TransferRepo transferRepo;

	@Transactional
	@Override
	public int transfer(TransferForm form) {

		// Get Account From Information
		var fromAccount = accountRepo.findByAccountId(form.accountFrom())
				.orElseThrow(() -> new BusinessException("Invalid Account Number : %s".formatted(form.accountFrom())));

		// Check Amount to transfer
		if (fromAccount.amount().compareTo(form.amount()) < 0) {
			throw new BusinessException("%s has no enough amount to transfer.".formatted(form.accountFrom()));
		}

		// Initiate Transfer Transaction
		var trxId = transferRepo.initiate(form);

		// Create Account from balance history
		var fromHistory = BalanceHistoryForm.builder().accountNum(fromAccount.accountNum())
				.nextVersion(fromAccount.nextVersion()).trxId(trxId).trxAmount(form.amount()).isDebit(true)
				.lastAmount(fromAccount.amount()).remark(form.remark()).build();
		historyRepo.create(fromHistory);

		// Update Account Amount
		var fromAmountForm = AmountUpdateForm.builder().accountNum(fromAccount.accountNum())
				.updatedAmount(fromAccount.amount().subtract(form.amount())).nextVersion(fromAccount.nextVersion())
				.build();
		accountRepo.updateAmount(fromAmountForm);

		// Get Account to Information
		var toAccount = accountRepo.findByAccountId(form.accountTo())
				.orElseThrow(() -> new BusinessException("Invalid Account Number : %s".formatted(form.accountTo())));

		// Create Account to Balance History
		var toHistory = BalanceHistoryForm.builder().accountNum(toAccount.accountNum())
				.nextVersion(toAccount.nextVersion()).trxId(trxId).trxAmount(form.amount()).isDebit(false)
				.lastAmount(toAccount.amount()).remark(form.remark()).build();
		historyRepo.create(toHistory);

//		System.out.printf("%d", 1 / 0);

		// Update Account to Amount
		var toAccountForm = AmountUpdateForm.builder().accountNum(toAccount.accountNum())
				.updatedAmount(toAccount.amount().add(form.amount())).nextVersion(toAccount.nextVersion()).build();
		accountRepo.updateAmount(toAccountForm);

		// Update Transfer Transaction Status
		transferRepo.updateStatus(trxId, "Success");

		return trxId;
	}
}
