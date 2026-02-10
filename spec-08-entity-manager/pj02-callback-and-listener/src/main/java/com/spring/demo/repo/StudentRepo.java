package com.spring.demo.repo;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.demo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class StudentRepo {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public Student create(Student student) {
		em.persist(student);
		return student;
	}

	@Transactional
	public Student update(Student student) {
		return em.merge(student);
	}

}
