package com.capo.teradata.procedure;

import com.capo.teradata.service.ConvertionToStringService;

public class ConvertionToStringServiceImpl implements ConvertionToStringService{
	
	@Override
	public String intToString(int value) {
		return Integer.toString(value);
	}
	
	@Override
	public String longToString(Long value) {
		return Long.toString(value);
	}
	
	@Override
	public String stringToString(String value) {
		return value;
	}
}
