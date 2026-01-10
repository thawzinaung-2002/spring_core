package com.spring.txn.repo.impl;

import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SimplePropertySqlParameterSource;
import org.springframework.stereotype.Repository;

import com.spring.txn.dto.AccountInfo;
import com.spring.txn.dto.AmountUpdateForm;
import com.spring.txn.repo.AccountRepo;

@Repository
public class AccountRepoImpl implements AccountRepo {

	private static final String SEELCT_SQL = """
			select * from account where account_num=:accountNum
			""";

	private static final String UPDATE_SQL = """
			update account set version=:version,amount=:amount
			where account_num=:accountNum
			""";

	private NamedParameterJdbcTemplate namedJdbcTemplate;
	private RowMapper<AccountInfo> rowMapper;

	public AccountRepoImpl(DataSource dataSource) {
		namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		rowMapper = new DataClassRowMapper<>(AccountInfo.class);
	}

	@Override
	public Optional<AccountInfo> findByAccountId(String accountNum) {
		return namedJdbcTemplate.query(SEELCT_SQL, Map.of("accountNum", accountNum), rowMapper).stream().findAny();
	}

	@Override
	public void updateAmount(AmountUpdateForm fromAmountForm) {
		namedJdbcTemplate.update(UPDATE_SQL, new SimplePropertySqlParameterSource(fromAmountForm));
	}

}
