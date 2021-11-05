package com.capo.teradata.ejecucion;

import java.util.Map;
import java.util.stream.Collectors;

import com.capo.teradata.annotation.SearchingForAnnotation;
import com.capo.teradata.procedure.Convertion;
import com.capo.teradata.service.ConversionService;
import com.capo.teradata.service.EjecucionService;
import com.capo.teradata.service.SearchingForAnnotationService;

public class Ejecucion implements EjecucionService {
	
	SearchingForAnnotationService searchingForAnnotation= new SearchingForAnnotation();
	ConversionService conversion= Convertion.getConvertionObject();
	
	@Override
	public Map<String,String> getValues(Object... objects){
		Map<String,Object> values= searchingForAnnotation.getValuesFromAnnotationInServeralObjects(objects);
		Map<String,String> result=values.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,entry->conversion.convertion(entry.getValue())));
		return result;
	}
}
