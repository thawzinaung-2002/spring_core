package com.spring.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.data.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
