package com.spring.pos.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.spring.pos.domain.exceptions.PosBusinessException;
import com.spring.pos.domain.input.ShoppingCart;
import com.spring.pos.domain.output.SaleDetails;
import com.spring.pos.domain.output.SaleInfo;
import com.spring.pos.repository.SaleHistoryRepo;
import com.spring.pos.repository.SaleProductRepo;
import com.spring.pos.service.SaleService;

@Service
public class SaleServiceImpl implements SaleService{

	@Autowired
	private SaleHistoryRepo saleHistoryRepo;
	
	@Autowired
	private SaleProductRepo saleProductRepo;
	
	@Override
	public int checkOut(ShoppingCart cart) {

		validate(cart);
		
		//create sale history
		var saleId = saleHistoryRepo.create(cart.getSalePerson());
		
		for(var item: cart.getItems()) {
			saleProductRepo.create(saleId, item);
		}
		
		return saleId;
	}

	private void validate(ShoppingCart cart) {
		if(null == cart) {
			throw new PosBusinessException("Cart must not be empty.");
		}
		
		if(!StringUtils.hasLength(cart.getSalePerson())) {
			throw new PosBusinessException("Sale person must not be empty.");
		}
		
		if(null == cart.getItems() || cart.getItems().isEmpty()) {
			throw new PosBusinessException("Please enter sale items.");
		}
		
		for(var item: cart.getItems()) {
			if(null == item) {
				throw new PosBusinessException("Please enter items.");
			}
			
			if(!StringUtils.hasLength(item.getProductCode())) {
				throw new PosBusinessException("Please enter product code.");
			}
			
			if(item.getUnitPrice().intValue() <= 0) {
				throw new PosBusinessException("Invalid unit price.");
			}
			
			if(item.getQty() <= 0) {
				throw new PosBusinessException("Invalid quantity.");
			}
		}
	}

	@Override
	public List<SaleInfo> search(String salePerson, LocalDate from, LocalDate to) {
		return saleHistoryRepo.search(salePerson, from, to);
	}

	@Override
	public SaleDetails findById(int id) {
		var saleInfo = saleHistoryRepo.findById(id);
		
		var items = saleProductRepo.findBySaleId(id);
		
		return SaleDetails.from(saleInfo, items);
	}

}
