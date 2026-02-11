package com.spring.query.repo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.query.base.BaseRepo;
import com.spring.query.entity.Account;
import com.spring.query.entity.Account.Role;

public interface AccountRepo extends BaseRepo<Account, UUID> {

	Optional<Account> findOneByLoginId(String loginId);

	List<Account> findByRole(Role role);

	@Query(value = "select a from Account a where a.role = :role and a.activatedAt <= :now and a.expiredAt >= :now ")
	List<Account> searchActiveAccount(@Param("role") Role ro, LocalDateTime now);

}
