package com.spring.trx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.spring.trx.dto.AccountDto;
import com.spring.trx.dto.TransferForm;

@Service
public class TransferService {

	@Autowired
	private NamedParameterJdbcTemplate template;

	public int transfer(TransferForm form) {

		var historyId = createHistory(form);

		var accountFrom = findAccount(form.from());

		if (accountFrom.amount() < form.amount()) {

		}

		return 0;
	}

	private AccountDto findAccount(String from) {
		// TODO Auto-generated method stub
		return null;
	}

	private Object createHistory(TransferForm form) {
		// TODO Auto-generated method stub
		return null;
	}

}
