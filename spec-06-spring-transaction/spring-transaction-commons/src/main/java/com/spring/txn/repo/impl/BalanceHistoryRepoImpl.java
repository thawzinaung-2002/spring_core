package com.spring.txn.repo.impl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.SimplePropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.spring.txn.dto.BalanceHistoryForm;
import com.spring.txn.repo.BalanceHistoryRepo;

@Repository
public class BalanceHistoryRepoImpl implements BalanceHistoryRepo {

	private SimpleJdbcInsert insert;

	public BalanceHistoryRepoImpl(DataSource dataSource) {
		insert = new SimpleJdbcInsert(dataSource).withTableName("balance_history");
	}

	@Override
	public void create(BalanceHistoryForm fromHistory) {
		insert.execute(new SimplePropertySqlParameterSource(fromHistory));
	}

}
