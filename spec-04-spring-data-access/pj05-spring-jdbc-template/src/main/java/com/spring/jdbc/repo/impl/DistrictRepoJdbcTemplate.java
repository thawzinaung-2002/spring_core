package com.spring.jdbc.repo.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.spring.jdbc.domain.DistrictDto;
import com.spring.jdbc.repo.DistrictRepo;

@Repository
@Profile("jdbc")
public class DistrictRepoJdbcTemplate implements DistrictRepo {

	@Autowired
	private JdbcTemplate template;

	private static String SELECT_SQL = """
			SELECT DT.ID, DT.NAME, DV.ID divisionId, DV.NAME divisionName,
			count(TSP.ID) townships
			FROM DISTRICT DT
			join DIVISION DV
			on DT.DIVISION_ID=DV.ID
			join TOWNSHIP TSP
			on TSP.DISTRICT_ID=DV.ID
			""";

	private RowMapper<DistrictDto> rowMapper;

	public DistrictRepoJdbcTemplate() {
		rowMapper = new DataClassRowMapper<>(DistrictDto.class);
	}

	@Override
	public List<DistrictDto> search(Integer divisionId, String name) {

		var sql = new StringBuffer(SELECT_SQL).append(" where 1=1 ");
		var params = new ArrayList<Object>();

		if (null != divisionId && divisionId.intValue() > 0) {
			sql.append(" AND DV.ID = ? ");
			params.add(divisionId);
		}

		if (StringUtils.hasLength(name)) {
			sql.append(" AND lower(DT.NAME) LIKE ?");
			params.add(name.toLowerCase().concat("%"));
		}

		sql.append("GROUP BY DT.ID, DT.NAME, DV.ID, DV.NAME");
		
		return template.query(sql.toString(), rowMapper, params.toArray());
	}

	@Override
	public Optional<DistrictDto> findById(int id) {
		var result = template.query(SELECT_SQL.concat(" where DT.ID = ? GROUP BY DT.ID, DT.NAME, DV.ID, DV.NAME"), rowMapper, id);
		
		return Optional.of(result.stream().findAny().get());
	}

}
