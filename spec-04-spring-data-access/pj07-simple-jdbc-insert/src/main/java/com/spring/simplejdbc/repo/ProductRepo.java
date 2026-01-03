package com.spring.simplejdbc.repo;

import com.spring.simplejdbc.domain.ProductDetails;
import com.spring.simplejdbc.domain.ProductForm;

public interface ProductRepo {

	int create(ProductForm form);
	
	ProductDetails findById(int id);
	
}
