package com.capo.teradata.enums;

import com.capo.teradata.service.DatosEnum;

public enum InformationEnum implements DatosEnum{
	
	DATO_1("dato1","Buenos aires"),
	DATO_2("dato_2","Paris");
	
	String codigo;
	String valor;
	
	InformationEnum(String codigo,String valor) {
		this.codigo=codigo;
		this.valor=valor;
	} 
	
	@Override
	public String getValue() {
		return valor;
	}
}
