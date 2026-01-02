package com.spring.jdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.spring.jdbc.repo.DistrictRepo;

@SpringBootTest
//@ActiveProfiles("jdbc")
//@ActiveProfiles("named")
@ActiveProfiles("client")
public class DistrictRepoTest {

	@Autowired
	private DistrictRepo repo;
	
	@ParameterizedTest
	@CsvSource({
		"1,,8",
		"1,Hinthada,1",
		",,85",
		",Hinthada,1"
	})
	void search(Integer divisionId, String name, int size) {
		
		var result = repo.search(divisionId, name);
		
		assertEquals(result.size(), size);
	}
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/findById.txt", delimiter = ',')
	void findById(Integer id, String divName, Long townships) {
		
		var result = repo.findById(id);
		
		result.ifPresent(dto -> {
			assertEquals(dto.divisionName(), divName);
			assertEquals(dto.townships(), townships);
		});
	}
	
}
