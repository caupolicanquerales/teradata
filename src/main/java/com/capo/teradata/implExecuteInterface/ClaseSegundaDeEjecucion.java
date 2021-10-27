package com.capo.teradata.implExecuteInterface;

import java.util.Map;

import com.capo.teradata.chainingMethod.ClassChainingMethod;
import com.capo.teradata.dto.InformationThree;
import com.capo.teradata.enums.InformationEnum;
import com.capo.teradata.enums.InformationEnumTwo;
import com.capo.teradata.service.ExecuteService;

public class ClaseSegundaDeEjecucion implements ExecuteService{
	
	InformationThree informationThree;
	
	public ClaseSegundaDeEjecucion(InformationThree informationThree) {
		this.informationThree=informationThree;
	}
	
	
	@Override
	public void execute() {
		Map<String,Object> result= getMap();
		System.out.println("ClaseSegunda "+result);
	}
	
	private Map<String,Object> getMap(){
		return ClassChainingMethod.initialization().
				setValue(InformationEnum.DATO_1, informationThree.getPais()).
				setValue(InformationEnumTwo.DATO_4, informationThree.getSillas()).close();
	}
	
}
