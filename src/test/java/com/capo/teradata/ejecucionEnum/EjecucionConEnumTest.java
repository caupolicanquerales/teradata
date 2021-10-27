package com.capo.teradata.ejecucionEnum;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.capo.teradata.enums.InformationEnum;
import com.capo.teradata.enums.InformationEnumTwo;

@ExtendWith(SpringExtension.class)
class EjecucionConEnumTest {
	
	@InjectMocks
	EjecucionConEnum ejecucionConEnum;
	
	@Test
	void getValueFromEnumTest() {
		String result= ejecucionConEnum.getValueFromEnum(InformationEnum.DATO_2);
		assertEquals("Paris",result);
	}
	
	@Test
	void getValueFromEnumSecondTest() {
		String result= ejecucionConEnum.getValueFromEnum(InformationEnumTwo.DATO_4);
		assertEquals("Argentina",result);
	}

}
