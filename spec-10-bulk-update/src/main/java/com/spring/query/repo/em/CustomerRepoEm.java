package com.spring.query.repo.em;

import org.springframework.stereotype.Repository;

import com.spring.query.entity.Customer;
import com.spring.query.repo.CustomerRepo;
import com.spring.query.repo.CustomerRepoBase;

@Repository
public class CustomerRepoEm extends CustomerRepoBase implements CustomerRepo {

	@Override
	public int update(int id, String name, String phone) {
		var entity = em.find(Customer.class, id);

		if (null != entity) {
			entity.setName(name);
			entity.setPhone(phone);
			return entity.getId();
		}

		return 0;
	}

	@Override
	public int delete(int id) {
		var entity = em.find(Customer.class, id);
		if (null != entity) {
			em.remove(entity);
			return 1;
		}
		return 0;
	}

}
