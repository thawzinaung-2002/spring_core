package com.spring.jdbc.repo.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.spring.jdbc.domain.DivisionDto;
import com.spring.jdbc.repo.DivisionRepo;

@Repository
@Profile("jdbc")
public class DivisionRepoJdbcTemplate implements DivisionRepo{

	@Autowired
	private JdbcTemplate template;
	
	private RowMapper<DivisionDto> rowMapper;
	
	public DivisionRepoJdbcTemplate() {
		rowMapper = new DataClassRowMapper<>(DivisionDto.class);
	}
	
	@Value("${app.sql.division-select}")
	private String selectSql;
	
	@Value("${app.sql.division-group-by}")
	private String groupBy;
	
	@Override
	public List<DivisionDto> search(String name) {

		var sql = new StringBuffer(selectSql);
		
		var params = new ArrayList<Object>();
		
		if(StringUtils.hasLength(name)) {
			sql.append(" where lower(dv.name) like ?");
			params.add(name.toLowerCase().concat("%"));
		}
		
		sql.append(" ").append(groupBy);
		
		return template.query(sql.toString(), rowMapper, params.toArray());
	}

	@Override
	public Optional<DivisionDto> findById(int id) {
		
		var result = template.query("%s where dv.id=? %s".formatted(selectSql, groupBy), rowMapper, id);
		
		return Optional.ofNullable(result.stream().findFirst().get());
	}

}
