package com.spring.query.entity;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.util.StringUtils;

import jakarta.persistence.AttributeConverter;

public class DaysConverter implements AttributeConverter<List<DayOfWeek>, String> {

	@Override
	public String convertToDatabaseColumn(List<DayOfWeek> attribute) {
		return Optional.ofNullable(attribute).filter(list -> !list.isEmpty())
				.map(list -> list.stream().map(DayOfWeek::name).collect(Collectors.joining(","))).orElse(null);

	}

	@Override
	public List<DayOfWeek> convertToEntityAttribute(String dbData) {
		if (StringUtils.hasLength(dbData)) {
			return Arrays.stream(dbData.split(",")).map(DayOfWeek::valueOf).collect(Collectors.toList());
		}
		return null;
	}

}
