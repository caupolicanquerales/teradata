package com.capo.teradata.procedure;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class ConvertionToStringServiceImplTest {
	
	@InjectMocks
	ConvertionToStringServiceImpl convertion;
	
	@Test
	void convertionIntToStringTest() {
		int numero=10;
		String result=convertion.intToString(numero);
		assertEquals("10", result);
	}
	
	@Test
	void convertionLongToStringTest() {
		Long numero=10L;
		String result=convertion.longToString(numero);
		assertEquals("10", result);
	}
	
	@Test
	void convertionStringToStringTest() {
		String numero="10";
		String result=convertion.stringToString(numero);
		assertEquals("10", result);
	}
}
