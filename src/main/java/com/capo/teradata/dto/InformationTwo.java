package com.capo.teradata.dto;

import com.capo.teradata.annotation.Teradata;

public class InformationTwo extends Information{
	
	@Teradata(key="cuidades_codigo")
	private String cuidades;
	private String apellido;
	
	public String getCuidades() {
		return cuidades;
	}
	public void setCuidades(String cuidades) {
		this.cuidades = cuidades;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
}
