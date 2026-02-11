package com.spring.query.service;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.spring.query.dto.input.CustomerSearch;
import com.spring.query.dto.output.CustomerDto;
import com.spring.query.entity.Account_;
import com.spring.query.entity.Customer;
import com.spring.query.entity.Customer_;
import com.spring.query.repo.CustomerRepo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo customerRepo;

	public List<CustomerDto> search(CustomerSearch search) {
		Function<CriteriaBuilder, CriteriaQuery<CustomerDto>> queryFunc = cb -> {
			var cq = cb.createQuery(CustomerDto.class);
			var root = cq.from(Customer.class);

			CustomerDto.select(cq, root);

			cq.where(search.where(cb, root));

			cq.orderBy(cb.desc(root.get(Customer_.account).get(Account_.activatedAt)));

			return cq;
		};

		return customerRepo.search(queryFunc);
	}

	public List<CustomerDto> searchByExample(CustomerSearch search) {

		var probe = new Customer();

		if (StringUtils.hasLength(search.name())) {
			probe.setName(search.name());
		}

		if (StringUtils.hasLength(search.phone())) {
			probe.setPhone(search.phone());
		}

		if (StringUtils.hasLength(search.email())) {
			probe.setEmail(search.email());
		}

		if (null != search.gender()) {
			probe.setGender(search.gender());
		}

		var example = Example.of(probe, ExampleMatcher.matching().withIgnoreCase("name", "phone", "email")
				.withStringMatcher(StringMatcher.STARTING));

		return customerRepo.findBy(example, fq -> fq.stream().map(CustomerDto::from).toList());
	}

	public List<CustomerDto> searchBySpecification(CustomerSearch search) {

		Specification<Customer> spec = (root, query, cb) -> {

			var array = search.where(cb, root);
			return cb.and(array);

		};

		return customerRepo.findAll(spec).stream().map(CustomerDto::from).toList();
	}

}
