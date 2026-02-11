package com.spring.query;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.spring.query.base.BaseRepoImpl;

@EnableJpaRepositories(repositoryBaseClass = BaseRepoImpl.class)
@SpringBootApplication
public class Spec11SpecificCustomRepoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spec11SpecificCustomRepoApplication.class, args);
	}

}
