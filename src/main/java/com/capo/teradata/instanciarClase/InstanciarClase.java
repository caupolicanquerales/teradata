package com.capo.teradata.instanciarClase;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.capo.teradata.service.ExecuteService;
import com.capo.teradata.service.InstanciarClaseService;

public class InstanciarClase implements InstanciarClaseService {
	
	private InstanciarClase() {
		
	}
	public static InstanciarClaseService getObject() {
		return new InstanciarClase();
	}
	
	@Override
	public  <E,T,R> ExecuteService instantiationClass(Class<E> cls,T request, R response) {
		ExecuteService executeService = null;
		try {
			Constructor<E> constructor= (Constructor<E>) cls.getDeclaredConstructor(Object.class,Object.class);
			constructor.setAccessible(true);
			executeService=(ExecuteService) constructor.newInstance(request,response);
			
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException | IllegalArgumentException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return executeService;
	}
}
