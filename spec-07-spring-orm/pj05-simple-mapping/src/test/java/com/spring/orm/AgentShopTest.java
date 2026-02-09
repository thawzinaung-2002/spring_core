package com.spring.orm;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.orm.entity.AgentShop;
import com.spring.orm.entity.repo.AgentShopRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@SpringBootTest
public class AgentShopTest {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private AgentShopRepo repo;

	@Test
	void create() {
		var shop = new AgentShop();
		shop.setShortCode("SH0001");
		shop.setShopName("Thit Sar");
		shop.setOwnerName("Thidar Aung");
		shop.setPhone("09779580179");
		shop.setLat(12.22);
		shop.setLon(20.12);
		shop.setStartDate(LocalDate.now());
		shop.setOpenHour("8:00");
		shop.setCloseHour("20:00");

//		em.persist(shop);
		repo.save(shop);

	}

}
