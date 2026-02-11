package com.spring.query.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.query.entity.Staff;
import com.spring.query.entity.Staff.Position;
import com.spring.query.entity.Staff_;
import com.spring.query.repo.StaffRepo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;

@Service
public class OfficeService {

	@Autowired
	private StaffRepo repo;

	@Transactional(readOnly = true)
	public Long searchCount(Position position, LocalDate entryForm) {
		return repo.count(countFunc(position, entryForm));
	}

	private Function<CriteriaBuilder, CriteriaQuery<Long>> countFunc(Position position, LocalDate entryForm) {
		return cb -> {
			var cq = cb.createQuery(Long.class);
			var root = cq.from(Staff.class);

			cq.select(cb.count(root.get(Staff_.id)));

			var list = new ArrayList<Predicate>();

			if (null != position) {
				list.add(cb.equal(root.get(Staff_.position), position));
			}

			if (null != entryForm) {
				list.add(cb.greaterThanOrEqualTo(root.get(Staff_.entryAt), entryForm));
			}

			cq.where(list.toArray(size -> new Predicate[size]));

			return cq;

		};
	}

}
