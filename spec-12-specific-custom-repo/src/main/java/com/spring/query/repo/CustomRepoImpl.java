package com.spring.query.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.query.dto.input.CustomerSearch;
import com.spring.query.dto.output.CustomerDto;
import com.spring.query.entity.Account_;
import com.spring.query.entity.Customer;
import com.spring.query.entity.Customer_;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CustomRepoImpl implements CustomRepo {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<CustomerDto> search(CustomerSearch search) {

		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(CustomerDto.class);
		var root = cq.from(Customer.class);

		CustomerDto.select(cq, root);

		if (null != search) {
			cq.where(search.where(cb, root));
		}

		cq.orderBy(cb.desc(root.get(Customer_.account).get(Account_.activatedAt)));

		return em.createQuery(cq).getResultList();
	}

}
