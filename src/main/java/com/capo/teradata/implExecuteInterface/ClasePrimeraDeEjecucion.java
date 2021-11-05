package com.capo.teradata.implExecuteInterface;

import java.util.Map;

import com.capo.teradata.chainingMethod.ClassChainingMethod;
import com.capo.teradata.dto.InformationThree;
import com.capo.teradata.dto.InformationTwo;
import com.capo.teradata.enums.InformationEnum;
import com.capo.teradata.enums.InformationEnumTwo;
import com.capo.teradata.service.ExecuteService;

public class ClasePrimeraDeEjecucion implements ExecuteService {
	
	private InformationTwo informationTwo;
	private InformationThree informationFour;
	
	public <T,R> ClasePrimeraDeEjecucion(T request,R response) {
		this.informationTwo=(InformationTwo) request;
		this.informationFour=(InformationThree)response;
	}
	
	@Override
	public Map<String,String> execute() {
		 return getMap();
	}
	
	private Map<String,String> getMap(){
		return ClassChainingMethod.initialization().
				setValue(InformationEnum.DATO_2, informationTwo.getApellido()).
				setValue(InformationEnumTwo.DATO_3, informationTwo.getCuidades()).
				setValue(InformationEnumTwo.DATO_4, informationTwo.getSueldo())
				.close();
	}
}
