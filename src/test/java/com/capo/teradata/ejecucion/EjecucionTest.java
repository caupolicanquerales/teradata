package com.capo.teradata.ejecucion;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.capo.teradata.dto.InformationThree;
import com.capo.teradata.dto.InformationTwo;

@ExtendWith(SpringExtension.class)
class EjecucionTest {
	
	@InjectMocks
	Ejecucion ejecucion; 
	
	InformationTwo informationTwo;
	InformationThree informationThree;
	
	@BeforeEach
	public void setUp() {
		informationTwo= new InformationTwo();
		informationTwo.setApellido("Cerati");
		informationTwo.setCuidades("Buenos Aires");
		informationThree= new InformationThree();
		informationThree.setPais("Argentina");
	}
	
	@Test
	void getValuesTest() {
		Map<String,String> result=ejecucion.getValues(informationTwo,informationThree);
		assertNotNull(result);
	}

}
