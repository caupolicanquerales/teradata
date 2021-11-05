package com.capo.teradata.procedure;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.capo.teradata.service.ConversionService;

public class Convertion implements ConversionService{
	
	private final String empty="";
	
	private Convertion() {
		
	}
	public static Convertion getConvertionObject() {
		return new Convertion();
	}
	
	@Override
	public String convertion(Object value) {
		Map<Boolean,String> convertion= new HashMap<>();
		convertion.put(condition(value,String.class),toString(value,String.class));
		convertion.put(condition(value,Integer.class),toInteger(value,Integer.class));
		convertion.put(condition(value,Long.class),toLong(value,Long.class));
		convertion.put(condition(value,Boolean.class),toBoolean(value,Boolean.class));
		convertion.put(condition(value,Float.class),toFloat(value,Float.class));
		convertion.put(condition(value,Date.class),toDate(value,Date.class));
		return convertion.get(Boolean.TRUE);
	}
	
	@Override
	public String convertion(String identificador,Object value) {
		Optional<String> result=Optional.ofNullable(convertionWithIdentification(identificador,value));
		return result.isPresent()?result.get():convertion(value);
	}
	
	private String convertionWithIdentification(String identificador,Object value) {
		Map<Boolean,String> convertion= new HashMap<>();
		convertion.put(conditionFromBooleanToNumber(identificador,value,Boolean.class),fromBooleanToNumber(identificador,value,Boolean.class));
		return convertion.get(Boolean.TRUE);
	}
	
	private boolean condition(Object value,Class<?>clazz) {
		return getConditionObject(value)?getConditionObjectType(value,clazz):Boolean.FALSE;		
	}
	private boolean conditionFromBooleanToNumber(String identificador,Object value,Class<?>clazz) {
		boolean condition= condition(value,clazz);
		return (identificador.equals("Boolean_to_number") && condition);
	}
	
	private boolean getConditionObject(Object value) {
		return Optional.ofNullable(value).isPresent();
	}
	private boolean getConditionObjectType(Object value,Class<?> clazz) {
		return value.getClass().equals(clazz)?Boolean.TRUE:Boolean.FALSE;
	}
	
	private String toInteger(Object value,Class<?>clazz) {
		if(condition(value,clazz)) {
			return Integer.toString((Integer)value);
		}
		return empty;
	}
	private String toString(Object value,Class<?>clazz) {
		if(condition(value,clazz)) {
			return (String)value;
		}
		return empty;
	}
	private String toLong(Object value,Class<?>clazz) {
		if(condition(value,clazz)) {
			return Long.toString((Long)value);
		}
		return empty;
	}
	private String toBoolean(Object value,Class<?>clazz) {
		if(condition(value,clazz)) {
			return Boolean.toString((Boolean)value);
		}
		return empty;
	}
	private String toFloat(Object value,Class<?>clazz) {
		if(condition(value,clazz)) {
			return Float.toString((Float)value);
		}
		return empty;
	}
	private String toDate(Object value,Class<?>clazz) {
		if(condition(value,clazz)) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss"); 
			return dateFormat.format((Date)value);
		}
		return empty;
	}
	private String fromBooleanToNumber(String identificador,Object value,Class<?>clazz) {
		if(conditionFromBooleanToNumber(identificador,value,clazz)) {
			return (Boolean)value==Boolean.TRUE?"1":"-1";
		}
		return empty;
	}
}
