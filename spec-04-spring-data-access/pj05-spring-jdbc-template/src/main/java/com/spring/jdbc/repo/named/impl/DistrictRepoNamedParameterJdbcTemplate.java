package com.spring.jdbc.repo.named.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.spring.jdbc.domain.DistrictDto;
import com.spring.jdbc.repo.DistrictRepo;

@Repository
@Profile("named")
public class DistrictRepoNamedParameterJdbcTemplate implements DistrictRepo{
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	private RowMapper<DistrictDto> rowMapper;
	
	@Value("${app.sql.district-select}")
	private String selectSql;
	
	@Value("${app.sql.district-group-by}")
	private String groupBy;
	
	public DistrictRepoNamedParameterJdbcTemplate() {
		rowMapper = new DataClassRowMapper<>(DistrictDto.class);
	}

	@Override
	public List<DistrictDto> search(Integer divisionId, String name) {
		var sql = new StringBuffer(selectSql);
		var params = new HashMap<String, Object>();
		
		if(null != divisionId) {
			sql.append(" and dv.id = :division");
			params.put("division", divisionId);
		}
		
		if(StringUtils.hasLength(name)) {
			sql.append(" and lower(dt.name) like :name ");
			params.put("name", name.toLowerCase().concat("%"));
		}
		
		sql.append(" ").append(groupBy);
		
		return template.query(sql.toString(), params, rowMapper);
	}

	@Override
	public Optional<DistrictDto> findById(int id) {
		
		var sql = "%s and DT.id = :id %s".formatted(selectSql, groupBy);
		
		return template.query(sql.toString(), Map.of("id", id), rowMapper).stream().findAny();
	}

}
