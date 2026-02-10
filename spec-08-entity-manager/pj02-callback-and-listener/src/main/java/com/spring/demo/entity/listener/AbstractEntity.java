package com.spring.demo.entity.listener;

import java.time.LocalDateTime;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
@EntityListeners(value = AccessTimeListener.class)
public abstract class AbstractEntity {

	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

}
