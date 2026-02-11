package com.spring.query.entity.repo.jpql;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.query.entity.dto.SectionDto;
import com.spring.query.entity.repo.SectionRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class SectionRepoJPQL implements SectionRepo {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<SectionDto> searchUnderFees(int fees) {

		var result = em.createNamedQuery("Section.searchUnderFees", SectionDto.class);
		result.setParameter("fees", fees);

		return result.getResultList();
	}

	@Override
	public List<SectionDto> searchStartBetween(LocalDate from, LocalDate to) {
		var result = em.createNamedQuery("Section.searchStartBetween", SectionDto.class);
		result.setParameter("from", from);
		result.setParameter("to", to);
		return result.getResultList();
	}

	@Override
	public List<SectionDto> searchStartTimeIn(List<String> times) {
		var result = em.createNamedQuery("Section.searchStartTimeIn", SectionDto.class);
		result.setParameter("times", times);
		return result.getResultList();
	}

}
