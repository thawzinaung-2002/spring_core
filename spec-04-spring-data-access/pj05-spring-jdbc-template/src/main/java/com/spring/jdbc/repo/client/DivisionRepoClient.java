package com.spring.jdbc.repo.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.spring.jdbc.domain.DivisionDto;
import com.spring.jdbc.repo.DivisionRepo;

@Repository
@Profile("client")
public class DivisionRepoClient implements DivisionRepo{
	
	@Autowired
	private JdbcClient client;
	
	private RowMapper<DivisionDto> rowMapper;
	
	private static final String SELECT_SQL = """
			select dv.id, dv.name, count(ds.id) count from DIVISION dv
			JOIN DISTRICT ds on ds.division_id=dv.id
			""";
	
	private static final String GROUP_BY = """
			group by dv.id, dv.name
			""";
	
	public DivisionRepoClient() {
		rowMapper = new DataClassRowMapper<>(DivisionDto.class);
	}

	@Override
	public List<DivisionDto> search(String name) {
		
		var sql = new StringBuffer(SELECT_SQL);
		var list = new ArrayList<Object>();
		
		if(StringUtils.hasLength(name)) {
			sql.append(" where lower(dv.name) like ? ");
			list.add(name.toLowerCase().concat("%"));
		}
		
		sql.append(" ").append(GROUP_BY);
		
		return client.sql(sql.toString())
					 .params(list)
					 .query(rowMapper)
					 .list();
	}

	@Override
	public Optional<DivisionDto> findById(int id) {
		return client.sql("%s where dv.id = ? %s ".formatted(SELECT_SQL, GROUP_BY))
				.param(id)
				.query(rowMapper)
				.optional();
	}

}
