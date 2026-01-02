package com.spring.pos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.spring.pos.domain.exceptions.PosBusinessException;
import com.spring.pos.domain.output.ProductDto;
import com.spring.pos.repository.ProductRepo;
import com.spring.pos.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo repo;

	@Override
	public ProductDto findByCode(String code) {

		if (!StringUtils.hasLength(code)) {
			throw new PosBusinessException("Please enter product code.");
		}

		return repo.findByCode(code).orElseThrow(() -> new PosBusinessException("Invalid product code."));
	}

}
