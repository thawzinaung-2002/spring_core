package com.spring.query.entity.repo.criteria;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.query.entity.Section;
import com.spring.query.entity.SectionPk_;
import com.spring.query.entity.Section_;
import com.spring.query.entity.dto.SectionDto;
import com.spring.query.entity.repo.SectionRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class SectionRepoCriteria implements SectionRepo {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<SectionDto> searchUnderFees(int fees) {

		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(SectionDto.class);
		var root = cq.from(Section.class);

		SectionDto.select(cq, root);

		var predicats = cb.le(root.get(Section_.fees), fees);
		cq.where(predicats);

		var result = em.createQuery(cq);

		return result.getResultList();
	}

	@Override
	public List<SectionDto> searchStartBetween(LocalDate from, LocalDate to) {
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(SectionDto.class);
		var root = cq.from(Section.class);

		SectionDto.select(cq, root);

		var predicats = cb.between(root.get(Section_.pk).get(SectionPk_.startAt), from, to);
		cq.where(predicats);

		var result = em.createQuery(cq);

		return result.getResultList();
	}

	@Override
	public List<SectionDto> searchStartTimeIn(List<String> times) {
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(SectionDto.class);
		var root = cq.from(Section.class);

		SectionDto.select(cq, root);

		var predicates = root.get(Section_.startTime).in(times);
		cq.where(predicates);

		var result = em.createQuery(cq);

		return result.getResultList();
	}

}
