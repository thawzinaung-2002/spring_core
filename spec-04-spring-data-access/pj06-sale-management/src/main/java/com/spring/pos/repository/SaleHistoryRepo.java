package com.spring.pos.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.spring.pos.domain.output.SaleInfo;

public interface SaleHistoryRepo {

	int create(String salePerson);

	Optional<SaleInfo> findById(int id);

	List<SaleInfo> search(String salePerson, LocalDate from, LocalDate to);

}
