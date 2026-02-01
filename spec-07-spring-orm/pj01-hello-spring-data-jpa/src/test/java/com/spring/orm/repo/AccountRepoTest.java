package com.spring.orm.repo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.orm.entity.Account;
import com.spring.orm.entity.repo.AccountRepo;

@SpringBootTest
public class AccountRepoTest {

	@Autowired
	private AccountRepo accountRepo;

	@Test
	void loadConfig() {
		var account = new Account();
		account.setCode("001");
		account.setEmail("aungaung@gmail.com");
		account.setName("Aung Aung");
		account.setPhone("09779580179");
		accountRepo.save(account);

	}

}
