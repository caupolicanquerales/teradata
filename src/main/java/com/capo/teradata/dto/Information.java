package com.capo.teradata.dto;

import com.capo.teradata.annotation.Teradata;

public class Information {
	
	@Teradata(key="nombre_codigo")
	private String nombre;
	
	@Teradata(key="sueldo")
	private Long sueldo;
	
	private int year;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getSueldo() {
		return sueldo;
	}
	public void setSueldo(Long sueldo) {
		this.sueldo = sueldo;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
}
