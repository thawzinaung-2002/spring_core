package com.spring.em.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.spring.em.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class StudentEntityDemoRepo {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private PlatformTransactionManager transactionManager;

	public void demo() {

		// Transient
		var entity = new Student();

		entity.setName("Demo Student");
		entity.setPhone("09111111111");
		var trx1 = transactionManager.getTransaction(new DefaultTransactionDefinition());
		// Manage State
		em.persist(entity);
		transactionManager.commit(trx1);

		em.clear();

		var newEntity = em.find(Student.class, entity.getId());
		var trx2 = transactionManager.getTransaction(new DefaultTransactionDefinition());
		em.detach(newEntity);
		newEntity.setName("Update Name");
		em.merge(newEntity);
		transactionManager.commit(trx2);

		var trx3 = transactionManager.getTransaction(new DefaultTransactionDefinition());
		var response = em.merge(newEntity);// Return object only will managed state
		em.remove(response);
		transactionManager.commit(trx3);

	}

}
