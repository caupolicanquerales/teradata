package com.capo.teradata.implExecuteInterface;

import java.util.Map;

import com.capo.teradata.chainingMethod.ClassChainingMethod;
import com.capo.teradata.dto.InformationThree;
import com.capo.teradata.dto.InformationTwo;
import com.capo.teradata.enums.InformationEnum;
import com.capo.teradata.enums.InformationEnumTwo;
import com.capo.teradata.service.ExecuteService;

public class  ClaseSegundaDeEjecucion implements ExecuteService{
	
	private InformationThree informationThree;
	private InformationThree informationFour;
	
	public <T,R> ClaseSegundaDeEjecucion(T request,R response) {
		this.informationThree=(InformationThree) request;
		this.informationFour=(InformationThree)response;
	}
	
	@Override
	public Map<String,String> execute() {
		return getMap();
	}
	
	private Map<String,String> getMap(){
		return ClassChainingMethod.initialization().
				setValue(InformationEnum.DATO_1, informationThree.getPais()).
				setValue(InformationEnumTwo.DATO_4, informationThree.getSillas()).close();
	}
	
}
