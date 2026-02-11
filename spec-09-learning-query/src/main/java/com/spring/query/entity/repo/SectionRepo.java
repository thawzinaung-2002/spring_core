package com.spring.query.entity.repo;

import java.time.LocalDate;
import java.util.List;

import com.spring.query.entity.dto.SectionDto;

public interface SectionRepo {

	List<SectionDto> searchUnderFees(int fees);

	List<SectionDto> searchStartBetween(LocalDate from, LocalDate to);

	List<SectionDto> searchStartTimeIn(List<String> times);
}
