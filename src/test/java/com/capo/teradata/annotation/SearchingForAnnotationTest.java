package com.capo.teradata.annotation;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.capo.teradata.dto.Information;
import com.capo.teradata.dto.InformationThree;
import com.capo.teradata.dto.InformationTwo;

@ExtendWith(SpringExtension.class)
public class SearchingForAnnotationTest {
	
	@InjectMocks
	SearchingForAnnotation searching;
	
	private Information information;
	private InformationTwo informationTwo;
	private InformationThree informationThree;
	
	@BeforeEach
	public void setUp() {
		information=new Information();
		information.setSueldo(200L);
		information.setNombre("Capo");
		informationTwo= new InformationTwo(); 
		informationTwo.setCuidades("Buenos aires");
		informationTwo.setSueldo(null);
		informationTwo.setNombre("Martha");
		informationThree= new InformationThree();
		informationThree.setPais("Argentina");
		informationThree.setSillas(40);
	}
	
	@Test
	public void getValuesFromAnnotationFieldTest() {
		Map<String,Object > result=searching.getValuesFromAnnotationField(information);
		assertNotNull(result);
	}
	
	@Test
	public void getValuesFromAnnotationWithComplexDtoTest() {
		Map<String,Object > result=searching.getValuesFromAnnotationField(informationTwo);
		assertNotNull(result);
	}
	
	@Test
	public void getValuesFromAnnotationInServeralObjectsTest() {
		Map<String,Object > result=searching.getValuesFromAnnotationInServeralObjects(informationThree,informationTwo);
		assertNotNull(result);
	}

}
