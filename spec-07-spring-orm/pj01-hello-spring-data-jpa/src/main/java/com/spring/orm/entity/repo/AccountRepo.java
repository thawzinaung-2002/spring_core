package com.spring.orm.entity.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.orm.entity.Account;

public interface AccountRepo extends JpaRepository<Account, String> {

}
