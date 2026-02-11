package com.spring.query.entity.repo.jpql;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.query.entity.Course;
import com.spring.query.entity.dto.CourseDto;
import com.spring.query.entity.repo.CourseRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CourseRepoJPQL implements CourseRepo {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Course> findAll() {

//		var jpql = "select c from Course c ";
//		var query = em.createQuery(jpql, Course.class);

		var query = em.createNamedQuery("Course.findAll", Course.class);

		return query.getResultList();
	}

	@Override
	public List<String> findAllName() {

		var query = em.createNamedQuery("Course.findAllNames", String.class);

		return query.getResultList();
	}

	@Override
	public Long countAll() {
		var query = em.createNamedQuery("Course.countAll", Long.class);

		return query.getSingleResult();
	}

	@Override
	public Double findAverageHours() {
		var query = em.createNamedQuery("Course.findAverageHours", Double.class);

		return query.getSingleResult();
	}

	@Override
	public Long sumFees() {
		var query = em.createNamedQuery("Course.findSumFees", Long.class);

		return query.getSingleResult();
	}

	@Override
	public List<CourseDto> findAllDto() {
		var query = em.createNamedQuery("Course.findAllDto", CourseDto.class);

		return query.getResultList();
	}

}
