package com.spring.pos.repository.impl;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.spring.pos.domain.output.SaleInfo;
import com.spring.pos.repository.SaleHistoryRepo;

@Repository
public class SaleHistoryRepoImpl implements SaleHistoryRepo{
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private RowMapper<SaleInfo> rowMapper = new DataClassRowMapper<>(SaleInfo.class);

	@Value("${sql.sale.history.select}")
	private String select;
	
	@Value("${sql.sale.history.insert}")
	private String insertSql;
	
	@Override
	public int create(String salePerson) {
		var keyHolder = new GeneratedKeyHolder();
		
		template.update(insertSql, 
				new MapSqlParameterSource().addValue("salePerson", salePerson), 
				keyHolder, new String[] {"id"});
		
		return keyHolder.getKey().intValue();
	}

	@Override
	public Optional<SaleInfo> findById(int id) {
		return template.query(select.formatted(" sh.id = :id "), Map.of("id", id), rowMapper)
				.stream()
				.findAny();
	}

	@Override
	public List<SaleInfo> search(String salePerson, LocalDate from, LocalDate to) {
		
		var predicates = new StringBuffer(" 1=1 ");
		var params = new HashMap<String, Object>();
		
		if(StringUtils.hasLength(salePerson)) {
			predicates.append(" and sh.sale_person=:person ");
			params.put("person", salePerson);
		}
		
		if(null != from) {
			predicates.append(" and sh.sale_at >= :from ");
			params.put("from", Timestamp.valueOf(from.atStartOfDay()));
		}
		
		if(null != to) {
			predicates.append(" and sh.sale_at <= :to ");
			params.put("to", Timestamp.valueOf(to.plusDays(1).atStartOfDay()));
		}
		
		return template.query(select.formatted(predicates.toString()), params, rowMapper);
		
	}

}
