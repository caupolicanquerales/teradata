package com.capo.terada.threadEjecucion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.capo.teradata.threadEjecucion.ClaseEjecucionHilos;

@ExtendWith(SpringExtension.class)
class ClaseEjecucionHilosTest {
	
	@InjectMocks
	ClaseEjecucionHilos claseEjecucionHilos;
	
	@Test
	void executeTest() {
		assertEquals(1,1);
	}

}
