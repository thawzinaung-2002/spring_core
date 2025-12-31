package com.spring.jdbc.repo;

import java.util.List;
import java.util.Optional;

import com.spring.jdbc.domain.DivisionDto;

public interface DivisionRepo {

	List<DivisionDto> search(String name);
	Optional<DivisionDto> findById(int id);
	
	
}
