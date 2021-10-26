package com.capo.teradata.procedure;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.capo.teradata.service.ConversionService;
import com.capo.teradata.service.ConvertionToStringService;

public class Convertion implements ConversionService{
	
	private String empty="";
	
	ConvertionToStringService convertionService= new ConvertionToStringServiceImpl();
	
	
	@Override
	public String convertion(Object value) {
		Map<Boolean,String> convertion= new HashMap<>();
		convertion.put(condition(value,String.class),toString(value,String.class));
		convertion.put(condition(value,Integer.class),toInteger(value,Integer.class));
		convertion.put(condition(value,Long.class),toLong(value,Long.class));
		return convertion.get(Boolean.TRUE);
	}
	
	private boolean condition(Object value,Class<?>clazz) {
		return getConditionObject(value)?getConditionObjectType(value,clazz):Boolean.FALSE;		
	}
	private boolean getConditionObject(Object value) {
		return Optional.ofNullable(value).isPresent();
	}
	private boolean getConditionObjectType(Object value,Class<?> clazz) {
		return value.getClass().equals(clazz)?Boolean.TRUE:Boolean.FALSE;
	}
	
	private String toInteger(Object value,Class<?>clazz) {
		if(condition(value,clazz)) {
			return convertionService.intToString((Integer)value);
		}
		return empty;
	}
	private String toString(Object value,Class<?>clazz) {
		if(condition(value,clazz)) {
			return convertionService.stringToString((String)value);
		}
		return empty;
	}
	private String toLong(Object value,Class<?>clazz) {
		if(condition(value,clazz)) {
			return convertionService.longToString((Long)value);
		}
		return empty;
	}
}
