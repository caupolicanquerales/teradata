package com.capo.teradata.dto;

import java.util.Date;

import com.capo.teradata.annotation.Teradata;

public class InformationTwo extends Information{
	
	@Teradata(key="cuidades_codigo")
	private String cuidades;
	private String apellido;
	private boolean ejecucion;
	private Date day;
	
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
	public boolean isEjecucion() {
		return ejecucion;
	}
	public void setEjecucion(boolean ejecucion) {
		this.ejecucion = ejecucion;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
}
