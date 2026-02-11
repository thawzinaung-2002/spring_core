package com.spring.query.repo.criteria;

import org.springframework.stereotype.Repository;

import com.spring.query.entity.Customer;
import com.spring.query.entity.Customer_;
import com.spring.query.repo.CustomerRepo;
import com.spring.query.repo.CustomerRepoBase;

@Repository
public class CustomerRepoCriteria extends CustomerRepoBase implements CustomerRepo {

	@Override
	public int update(int id, String name, String phone) {
		var cb = em.getCriteriaBuilder();
		var cq = cb.createCriteriaUpdate(Customer.class);
		var root = cq.from(Customer.class);

		cq.set(root.get(Customer_.name), name);
		cq.set(root.get(Customer_.phone), phone);

		cq.where(cb.equal(root.get(Customer_.id), id));

		return em.createQuery(cq).executeUpdate();
	}

	@Override
	public int delete(int id) {
		var cb = em.getCriteriaBuilder();
		var cq = cb.createCriteriaDelete(Customer.class);
		var root = cq.from(Customer.class);

		cq.where(cb.equal(root.get(Customer_.id), id));

		return em.createQuery(cq).executeUpdate();
	}

}
