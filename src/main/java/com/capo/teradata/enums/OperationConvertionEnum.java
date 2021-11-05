package com.capo.teradata.enums;

import com.capo.teradata.service.DatosEnum;

public enum OperationConvertionEnum implements DatosEnum{
	
	BOOLEAN_TO_NUMBER("Boolean","Boolean_to_number"),
	DATE_FORMAT_1("Date","Date_format_1");
	
	String codigo;
	String valor;
	
	OperationConvertionEnum(String codigo,String valor) {
		this.codigo=codigo;
		this.valor=valor;
	} 
	
	@Override
	public String getValue() {
		return valor;
	}
}
