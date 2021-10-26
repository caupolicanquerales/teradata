package com.capo.teradata.procedure;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
class ConvertionTest {
	
	@InjectMocks
	Convertion convertion;
	
	@Test
	void convertionInt() {
		int valor=10;
		String result=convertion.convertion(valor);
		assertEquals("10", result);
	}
	
	@Test
	void convertionLong() {
		Long valor=10L;
		String result=convertion.convertion(valor);
		assertEquals("10", result);
	}
	
	@Test
	void convertionString() {
		String valor="10";
		String result=convertion.convertion(valor);
		assertEquals("10", result);
	}
}
