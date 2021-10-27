package com.capo.teradata.enums;

import com.capo.teradata.service.DatosEnum;

public enum InformationEnumTwo implements DatosEnum{
	
	DATO_3("dato1","Colombia"),
	DATO_4("dato_2","Argentina");
	
	String codigo;
	String valor;
	
	InformationEnumTwo(String codigo,String valor) {
		this.codigo=codigo;
		this.valor=valor;
	} 
	
	@Override
	public String getValue() {
		return valor;
	}
}
