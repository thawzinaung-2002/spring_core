package com.spring.jdbc.dao;

import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import com.spring.jdbc.dto.AccountDto;
import com.spring.jdbc.dto.AccountForm;

@Component
public class AccountDaoImpl implements AccountDao{
	
	private JdbcTemplate jdbcTemplate;
	private RowMapper<AccountDto> rowMapper;
	
	public AccountDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		rowMapper = new DataClassRowMapper<>(AccountDto.class);
	}

	@Override
	public int create(AccountForm form) {
		var sql = "insert into ACCOUNT(name, phone) values (?,?)";
		var keys = new GeneratedKeyHolder();
		
		jdbcTemplate.update( con -> {
			var stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, form.name());
			stmt.setString(2, form.phone());
			return stmt;
		}, keys);
		
		return keys.getKey().intValue();
	}

	@Override
	public long count() {
		return jdbcTemplate.queryForObject(
				"select count(id) from ACCOUNT", Long.class);
	}

	@Override
	public AccountDto findById(int id) {
		var sql = "SELECT * from ACCOUNT where id=?";
//		return jdbcTemplate.queryForObject(sql, rowMapper, id);
		
		var list = jdbcTemplate.query(sql, rowMapper, id);
		if(list.size() > 0) {
			return list.get(0);
		}
		
		return null;
	}

}
