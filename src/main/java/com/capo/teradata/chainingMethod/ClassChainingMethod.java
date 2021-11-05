package com.capo.teradata.chainingMethod;

import java.util.HashMap;
import java.util.Map;

import com.capo.teradata.procedure.Convertion;
import com.capo.teradata.service.ConversionService;
import com.capo.teradata.service.DatosEnum;

public class ClassChainingMethod {
	
	ConversionService conversion= Convertion.getConvertionObject();
	
	private Map<String,String> mapValue;
	
	private ClassChainingMethod() {
		mapValue= new HashMap<>();
	}
	
	public static ClassChainingMethod initialization() {
		return new ClassChainingMethod();
	}
	
	public  ClassChainingMethod setValue(DatosEnum key,Object value){
		String valueString=conversion.convertion(value);
		String valueKey=key.getValue();
		mapValue.put(valueKey,valueString);
		return this;
	}
	public  ClassChainingMethod setValue(DatosEnum key,DatosEnum identicador,Object value){
		String valueString=conversion.convertion(identicador.getValue(), value);
		String valueKey=key.getValue();
		mapValue.put(valueKey,valueString);
		return this;
	}
	
	public Map<String,String> close(){
		return mapValue;
	}
}
