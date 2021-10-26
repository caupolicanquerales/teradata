package com.capo.teradata.annotation;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;

import com.capo.teradata.service.SearchingForAnnotationService;

public class SearchingForAnnotation implements SearchingForAnnotationService{
	
	private static Logger logger;
	private static final String ERROR = "Error.";
	Class<?> clazz;
	Map<String,Object > valueMap;
	
	@Override
	public Map<String,Object > getValuesFromAnnotationInServeralObjects(Object... fieldDTOs){
		if(Objects.nonNull(fieldDTOs)) {
			return Stream.of(fieldDTOs).map(fieldDTO->getValuesFromAnnotationField(fieldDTO)).
			flatMap(map->map.entrySet().stream()).
			collect(Collectors.toMap(Map.Entry::getKey,entry->extracted(entry)));
		}
		return null;
	}
	
	@Override
	public Map<String,Object > getValuesFromAnnotationField(Object fieldDTO) {
		valueMap = new HashMap<>();
		boolean paso = Boolean.FALSE;
		clazz = getClass(fieldDTO);
		do {
			try {
				Field[] fields = methodToGetFields(clazz);
				Stream.of(fields).filter(field -> field.isAnnotationPresent(Teradata.class)).forEach(field ->setValueToMap(fieldDTO,field));
			} catch (Exception e) {
				logger.error(ERROR, e);
			}
			clazz = clazz.getSuperclass();
			if (clazz == null) {
				paso = true;
			}
		} while (!paso);
		return valueMap;
	}
	
	
	private Class<?> getClass(Object fieldDTO) {
		return fieldDTO.getClass();
	}
	
	private Field[] methodToGetFields(Class<?> clazz) {
		Field[] field = null;
		try {
			field = clazz.getDeclaredFields();
		} catch (Exception e) { 
			logger.error(ERROR, e);
		}
		return field;
	}
	private void setValueToMap(Object fieldDTO, Field field) {
		try {
			String name= field.getName();
			Field campo = clazz.getDeclaredField(name);
			campo.setAccessible(true);
			Teradata nombreT= campo.getAnnotation(Teradata.class);
			valueMap.put(nombreT.key(),campo.get(fieldDTO));
		} catch (Exception ex) {
			logger.error(ERROR, ex);
		}
	}
	
	private Object extracted(Entry<String, Object> entry) {
		if(Objects.nonNull(entry.getValue())) {
			return entry.getValue();
		}
		return new String("Value no present");	
	}
	
}
