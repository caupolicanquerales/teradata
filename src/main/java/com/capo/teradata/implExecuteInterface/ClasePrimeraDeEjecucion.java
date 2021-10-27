package com.capo.teradata.implExecuteInterface;

import java.util.Map;

import com.capo.teradata.chainingMethod.ClassChainingMethod;
import com.capo.teradata.dto.InformationTwo;
import com.capo.teradata.enums.InformationEnum;
import com.capo.teradata.enums.InformationEnumTwo;
import com.capo.teradata.service.ExecuteService;

public class ClasePrimeraDeEjecucion implements ExecuteService {
	
	private InformationTwo informationTwo;
	
	public ClasePrimeraDeEjecucion(InformationTwo informationTwo) {
		this.informationTwo=informationTwo;
	}
	
	@Override
	public void execute() {
		Map<String,Object> result=getMap();
		System.out.println("ClasePrimera "+result);
	}
	
	private Map<String,Object> getMap(){
		return ClassChainingMethod.initialization().
				setValue(InformationEnum.DATO_2, informationTwo.getApellido()).
				setValue(InformationEnumTwo.DATO_3, informationTwo.getCuidades()).
				setValue(InformationEnumTwo.DATO_4, informationTwo.getSueldo())
				.close();
	}
}
