package com.spring.pos.repository;

import java.time.LocalDate;
import java.util.List;

import com.spring.pos.domain.output.SaleInfo;

public interface SaleHistoryRepo {

	int create(String salePerson);

	SaleInfo findById(int id);

	List<SaleInfo> search(String salePerson, LocalDate from, LocalDate to);

}
