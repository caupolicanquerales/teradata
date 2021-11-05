package com.capo.teradata.instanciarClase;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.capo.teradata.dto.InformationThree;
import com.capo.teradata.dto.InformationTwo;
import com.capo.teradata.implExecuteInterface.ClasePrimeraDeEjecucion;
import com.capo.teradata.implExecuteInterface.ClasePrueba;
import com.capo.teradata.service.ExecuteService;

@ExtendWith(SpringExtension.class)
class InstanciarClaseTest {
	
	private InformationThree informationThree;
	private InformationTwo informationTwo;
	
	@BeforeEach
	public void setUp() {
		informationThree= new InformationThree();
		informationThree.setPais("Argentina");
		informationThree.setSillas(23);
		
		informationTwo= new InformationTwo();
		informationTwo.setApellido("Querales");
		informationTwo.setEjecucion(false);
	}
	
	@Test
	void getInstanciarClaseTest() {
		ExecuteService result= InstanciarClase.getObject().instantiationClass(ClasePrimeraDeEjecucion.class,informationTwo,informationThree);
		Map<String, String> nombre=result.execute();
		assertNotNull(nombre);
	}

}
