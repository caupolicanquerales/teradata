package com.capo.terada.chainingMethod;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.capo.teradata.chainingMethod.ClassChainingMethod;
import com.capo.teradata.dto.InformationTwo;
import com.capo.teradata.enums.InformationEnum;
import com.capo.teradata.enums.InformationEnumTwo;

@ExtendWith(SpringExtension.class)
public class ClassChainingMethodTest {
	
	private InformationTwo informationTwo;
	
	@BeforeEach
	public void setUp() {
		informationTwo= new InformationTwo();
		informationTwo.setApellido("Lazaro");
		informationTwo.setSueldo(1234L);
		informationTwo.setYear(2021);
	}
	
	@Test
	public void getClassChainingMethodTest() {
		Map<String,Object> map=ClassChainingMethod.initialization()
				.setValue(InformationEnum.DATO_1,informationTwo.getApellido())
				.setValue(InformationEnum.DATO_2,informationTwo.getSueldo())
				.setValue(InformationEnumTwo.DATO_4, informationTwo.getYear())
				.close();
		assertNotNull(map);
	}
}
