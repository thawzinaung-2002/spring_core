package com.spring.query.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.spring.query.base.BaseRepo;
import com.spring.query.entity.Customer;

public interface CustomerRepo extends BaseRepo<Customer, UUID>, CustomRepo, JpaSpecificationExecutor<Customer> {

}
