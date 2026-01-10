package com.spring.txn;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = { "com.spring.txn.service", "com.spring.txn.repo" })
@EnableTransactionManagement
public class ApplicationConfig {

	@Bean
	DataSource dataSource() {
		var bean = new HikariDataSource();
		bean.setJdbcUrl("jdbc:mysql://localhost:3306/trxDb");
		bean.setUsername("trxdb");
		bean.setPassword("trxdb");
		return bean;
	}

//	@Bean
//	ResourceDatabasePopulator populator() {
//		var bean = new ResourceDatabasePopulator();
//		bean.addScript(new ClassPathResource("/schema.sql"));
//		bean.addScript(new ClassPathResource("/data.sql"));
//		return bean;
//	}

	@Bean
	DataSourceInitializer initializer() {
		var bean = new DataSourceInitializer();
		bean.setDataSource(dataSource());
		bean.setEnabled(true);
		var populator = new ResourceDatabasePopulator();
		populator.addScript(new ClassPathResource("/schema.sql"));
		populator.addScript(new ClassPathResource("/data.sql"));
		bean.setDatabasePopulator(populator);

		return bean;
	}

	@Bean
	PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

}
