package com.spring.pos.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.pos.domain.input.SaleItem;
import com.spring.pos.domain.output.SaleDetailsItem;
import com.spring.pos.repository.SaleProductRepo;

@Repository
public class SaleProductRepoImpl implements SaleProductRepo{

	@Override
	public void create(int saleId, SaleItem item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SaleDetailsItem> findBySaleId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
