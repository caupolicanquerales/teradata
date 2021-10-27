package com.capo.teradata.implExecuteInterface;

import com.capo.teradata.service.DatosEnum;
import com.capo.teradata.service.ExecuteService;

public class ClaseParaImprimirEnum implements ExecuteService {
	
	private DatosEnum enumItem;
	
	public ClaseParaImprimirEnum(DatosEnum enumItem) {
		this.enumItem=enumItem;
	}
	
	@Override
	public void execute() {
		System.out.println(enumItem.getValue());
		
	}
}
