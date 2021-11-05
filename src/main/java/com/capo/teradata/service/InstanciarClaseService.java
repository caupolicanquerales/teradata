package com.capo.teradata.service;

public interface InstanciarClaseService {
	public  <E,T,R> ExecuteService instantiationClass(Class<E> cls,T resquest, R response);
}
