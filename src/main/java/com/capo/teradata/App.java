package com.capo.teradata;

import com.capo.teradata.enums.InformationEnum;
import com.capo.teradata.enums.InformationEnumTwo;
import com.capo.teradata.implExecuteInterface.ClaseParaImprimirEnum;
import com.capo.teradata.service.EjecucionHilosService;
import com.capo.teradata.service.ExecuteService;
import com.capo.teradata.threadEjecucion.ClaseEjecucionHilos;

public class App {

	public static void main(String[] args) {
		EjecucionHilosService claseEjecucionHilos= new ClaseEjecucionHilos();
		ExecuteService paraImprimirEnum= new ClaseParaImprimirEnum(InformationEnumTwo.DATO_3);
		ExecuteService paraImprimirEnum2= new ClaseParaImprimirEnum(InformationEnum.DATO_1);
		System.out.println("Imprimiendo desde el test Primero");
		claseEjecucionHilos.execute(paraImprimirEnum,paraImprimirEnum2);
	}

}
