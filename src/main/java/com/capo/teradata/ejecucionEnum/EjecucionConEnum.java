package com.capo.teradata.ejecucionEnum;

import com.capo.teradata.service.DatosEnum;
import com.capo.teradata.service.EjecucionConEnumService;

public class EjecucionConEnum implements EjecucionConEnumService{
	
	@Override
	public String getValueFromEnum(DatosEnum enumItem) {
		return enumItem.getValue();
	}
}
