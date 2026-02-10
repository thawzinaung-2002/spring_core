package com.spring.em.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.spring.em.entity.Contact;
import com.spring.em.entity.Teacher;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class TeacherEntityDemo {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private PlatformTransactionManager transactionManager;

	public void demo() {
		var teacher = new Teacher();
		teacher.setName("Daw Mya");

		var contact = new Contact();
		contact.setPhone("09231235632");
		contact.setEmail("mya@gmail.com");
		contact.setTeacher(teacher);

		teacher.setContact(contact);

		var trx1 = transactionManager.getTransaction(new DefaultTransactionDefinition());
		em.persist(teacher);
		transactionManager.commit(trx1);

		var trx2 = transactionManager.getTransaction(new DefaultTransactionDefinition());
		var newTeacher = em.find(Teacher.class, teacher.getId());
		newTeacher.setContact(null);
		transactionManager.commit(trx2);

		var trx3 = transactionManager.getTransaction(new DefaultTransactionDefinition());
		var newTeacher2 = em.find(Teacher.class, teacher.getId());
		em.detach(newTeacher2);
		newTeacher2.setContact(contact);
		contact.setTeacher(newTeacher2);
		em.merge(newTeacher2);
		transactionManager.commit(trx3);

		var trx4 = transactionManager.getTransaction(new DefaultTransactionDefinition());
		var newTeacher3 = em.find(Teacher.class, teacher.getId());
		em.remove(newTeacher3);
		transactionManager.commit(trx4);

	}

}
