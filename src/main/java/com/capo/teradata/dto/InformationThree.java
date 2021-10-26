package com.capo.teradata.dto;

import com.capo.teradata.annotation.Teradata;

public class InformationThree {
	private int sillas;
	
	@Teradata(key="pais_codigo")
	private String pais;
	
	public int getSillas() {
		return sillas;
	}
	public void setSillas(int sillas) {
		this.sillas = sillas;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
}
