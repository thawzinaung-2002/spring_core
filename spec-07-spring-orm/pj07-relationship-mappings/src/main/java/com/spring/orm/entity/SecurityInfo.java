package com.spring.orm.entity;

import java.time.LocalDateTime;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class SecurityInfo {

	private LocalDateTime createAt;
	private LocalDateTime updateAt;
	private String createBy;
	private String updateBy;

}
