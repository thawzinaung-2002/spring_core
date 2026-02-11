package com.spring.query.entity.repo.criteria;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.query.entity.Course;
import com.spring.query.entity.Course_;
import com.spring.query.entity.dto.CourseDto;
import com.spring.query.entity.repo.CourseRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class CourseRepoCriteria implements CourseRepo {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Course> findAll() {

		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(Course.class);
		var root = cq.from(Course.class);

		cq.select(root);

		TypedQuery<Course> result = em.createQuery(cq);

		return result.getResultList();
	}

	@Override
	public List<String> findAllName() {
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(String.class);
		var root = cq.from(Course.class);

		cq.select(cb.construct(String.class, root.get(Course_.name)));

		TypedQuery<String> result = em.createQuery(cq);

		return result.getResultList();
	}

	@Override
	public Long countAll() {
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(Long.class);
		var root = cq.from(Course.class);

		cq.select(cb.construct(Long.class, cb.count(root.get(Course_.id))));

		TypedQuery<Long> result = em.createQuery(cq);

		return result.getSingleResult();
	}

	@Override
	public Double findAverageHours() {
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(Double.class);
		var root = cq.from(Course.class);

		cq.select(cb.construct(Double.class, cb.avg(root.get(Course_.hours))));

		TypedQuery<Double> result = em.createQuery(cq);

		return result.getSingleResult();
	}

	@Override
	public Long sumFees() {
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(Long.class);
		var root = cq.from(Course.class);

		cq.select(cb.construct(Long.class, cb.sum(root.get(Course_.fees))));

		TypedQuery<Long> result = em.createQuery(cq);

		return result.getSingleResult();
	}

	@Override
	public List<CourseDto> findAllDto() {
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(CourseDto.class);
		var root = cq.from(Course.class);

		cq.multiselect(root.get(Course_.id), root.get(Course_.name), root.get(Course_.fees));

		TypedQuery<CourseDto> result = em.createQuery(cq);

		return result.getResultList();
	}

}
