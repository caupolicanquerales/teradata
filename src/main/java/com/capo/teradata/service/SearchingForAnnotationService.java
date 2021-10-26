package com.capo.teradata.service;

import java.util.Map;

public interface SearchingForAnnotationService {
	public Map<String,Object > getValuesFromAnnotationField(Object fieldDTO);
	public Map<String,Object > getValuesFromAnnotationInServeralObjects(Object... fieldDTOs);
}
