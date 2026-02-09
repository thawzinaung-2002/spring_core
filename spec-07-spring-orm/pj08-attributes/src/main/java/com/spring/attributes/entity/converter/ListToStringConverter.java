package com.spring.attributes.entity.converter;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.util.StringUtils;

import jakarta.persistence.AttributeConverter;

public class ListToStringConverter implements AttributeConverter<List<String>, String> {

	@Override
	public String convertToDatabaseColumn(List<String> attribute) {
		return Optional.ofNullable(attribute).map(list -> list.stream().collect(Collectors.joining(","))).orElse(null);
	}

	@Override
	public List<String> convertToEntityAttribute(String dbData) {
		if (StringUtils.hasLength(dbData)) {
			var arr = dbData.split(",");
			return Arrays.asList(arr);
		}
		return null;
	}

}
