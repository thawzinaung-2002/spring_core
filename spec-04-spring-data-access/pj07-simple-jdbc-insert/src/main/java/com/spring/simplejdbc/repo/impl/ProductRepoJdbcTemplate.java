package com.spring.simplejdbc.repo.impl;

import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.spring.simplejdbc.domain.ProductDetails;
import com.spring.simplejdbc.domain.ProductForm;
import com.spring.simplejdbc.repo.ProductRepo;

@Repository
@Profile("jdbc")
public class ProductRepoJdbcTemplate implements ProductRepo{

	private static final String INSERT_SQL = """
			insert into PRODUCT(name, category, image, price) values (?,?,?,?)
			""";
	
	private JdbcTemplate template;
	private RowMapper<ProductDetails> rowMapper;
	
	public ProductRepoJdbcTemplate(DataSource dataSource) {
		rowMapper = new DataClassRowMapper<>(ProductDetails.class);
		template = new JdbcTemplate(dataSource);
	}
	
	@Override
	public int create(ProductForm form) {
		
		var keyholder = new GeneratedKeyHolder();
		
		template.update(con -> {
			var stmt = con.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, form.name());
			stmt.setString(2, form.category());
			stmt.setString(3, form.image());
			stmt.setBigDecimal(4, form.price());
			return stmt;
		}, keyholder);
		
		return keyholder.getKey().intValue();
	}

	@Override
	public ProductDetails findById(int id) {
		return template.queryForObject("select * from PRODUCT where id = ? ", rowMapper, id);
	}

}
