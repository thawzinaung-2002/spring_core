package com.spring.query.repo;

import java.util.List;

import com.spring.query.dto.input.CustomerSearch;
import com.spring.query.dto.output.CustomerDto;

public interface CustomRepo {

	List<CustomerDto> search(CustomerSearch search);

}
