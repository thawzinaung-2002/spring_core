package com.spring.data.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.data.dto.CustomerDto;
import com.spring.data.dto.CustomerName;
import com.spring.data.dto.IdAndName;
import com.spring.data.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	List<Customer> findByNameLike(String name);

	List<Customer> findByKeyword(String keyword);

	List<Customer> search(String keyword);

	@Query("""
			select c from Customer c where c.name like ?1
			or c.phone like ?1 or c.email like ?1
			""")
	List<Customer> findByKeyword2(String keyword);

	List<CustomerName> findNameByPhoneStartsWith(String phone);

	IdAndName findIdAndNameByEmailLike(String email);

	CustomerDto findIdNamePhoneByEmailLike(String email);

}
