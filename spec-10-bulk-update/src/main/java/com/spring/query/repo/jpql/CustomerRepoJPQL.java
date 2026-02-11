package com.spring.query.repo.jpql;

import org.springframework.stereotype.Repository;

import com.spring.query.repo.CustomerRepo;
import com.spring.query.repo.CustomerRepoBase;

@Repository
public class CustomerRepoJPQL extends CustomerRepoBase implements CustomerRepo {

	@Override
	public int update(int id, String name, String phone) {
		var query = em.createNamedQuery("Customer.update");
		query.setParameter("name", name);
		query.setParameter("phone", phone);
		query.setParameter("id", id);

		return query.executeUpdate();
	}

	@Override
	public int delete(int id) {
		var query = em.createNamedQuery("Customer.delete");
		query.setParameter("id", id);

		return query.executeUpdate();
	}

}
