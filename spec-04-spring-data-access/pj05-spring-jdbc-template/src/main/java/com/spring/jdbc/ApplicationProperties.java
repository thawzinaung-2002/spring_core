package com.spring.jdbc;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "app")
public class ApplicationProperties {

	private RepoConfig sql = new RepoConfig();
	
	@Data
	public static class RepoConfig {
		private String divisionSelect;
		private String divisionGroupBy;
		private String districtSelect;
		private String districtGroupBy;
	}
	
}
