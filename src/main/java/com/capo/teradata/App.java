package com.capo.teradata;

import com.capo.teradata.dto.InformationThree;
import com.capo.teradata.dto.InformationTwo;
import com.capo.teradata.implExecuteInterface.ClasePrimeraDeEjecucion;
import com.capo.teradata.implExecuteInterface.ClaseSegundaDeEjecucion;
import com.capo.teradata.service.EjecucionHilosService;
import com.capo.teradata.threadEjecucion.ClaseEjecucionHilos;

public class App {

	public static void main(String[] args) {
		
		System.out.println("Imprimiendo desde el test Primero");
		
		EjecucionHilosService claseEjecucionHilos= ClaseEjecucionHilos.getObject();
		claseEjecucionHilos.execute(ClasePrimeraDeEjecucion.class,setInformationTwo(),setInformationThree());
		claseEjecucionHilos.execute(ClaseSegundaDeEjecucion.class,setInformationThree(),setInformationThree());
		
		System.out.println("Imprimiendo desde el test Segundo");
	}
	
	private static InformationTwo setInformationTwo() {
		InformationTwo informationTwo=new InformationTwo();
		informationTwo.setApellido("Maradona");
		informationTwo.setCuidades("Buenos aires");
		informationTwo.setSueldo(11555000L);
		informationTwo.setYear(8989);
		return informationTwo;
	}
	private static InformationThree setInformationThree() {
		InformationThree informationThree=new InformationThree();
		informationThree.setPais("Argentina");
		informationThree.setSillas(48);
		return informationThree;
	}

}
