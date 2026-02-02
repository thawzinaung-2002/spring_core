package com.spring.orm;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@ComponentScan(basePackages = "com.spring.orm")
@EnableTransactionManagement
public class ApplicationConfig {

	@Bean
	DataSource dataSource() {
		var bean = new HikariDataSource();
		bean.setJdbcUrl("jdbc:mysql://localhost:3306/ormdb01");
		bean.setUsername("ormusr");
		bean.setPassword("ormpsw");
		return bean;
	}

	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		var bean = new LocalContainerEntityManagerFactoryBean();

		bean.setDataSource(dataSource());
		bean.setPackagesToScan("com.spring.orm");
		bean.setPersistenceProviderClass(HibernatePersistenceProvider.class);

		bean.setJpaPropertyMap(getJpaProperties());

		return bean;
	}

	private Map<String, ?> getJpaProperties() {
		var props = new HashMap<String, Object>();
		props.put("jakarta.persistence.schema-generation.database.action", "drop-and-create");
		props.put("hibernate.show_sql", true);
		props.put("hibernate.format_sql", true);
		return props;
	}

	@Bean
	PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		var bean = new JpaTransactionManager();
		bean.setEntityManagerFactory(emf);
		return bean;
	}

}
