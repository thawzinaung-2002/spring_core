package com.spring.pos.repository.impl;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.spring.pos.domain.output.ProductDto;
import com.spring.pos.repository.ProductRepo;

@Repository
public class ProductRepoImpl implements ProductRepo{

	@Override
	public Optional<ProductDto> findByCode(String code) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
