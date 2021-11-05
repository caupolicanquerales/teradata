package com.capo.teradata.threadEjecucion;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

import com.capo.teradata.instanciarClase.InstanciarClase;
import com.capo.teradata.service.EjecucionHilosService;
import com.capo.teradata.service.InstanciarClaseService;

public class ClaseEjecucionHilos implements EjecucionHilosService{
	
	private ClaseEjecucionHilos() {
		
	}
	public static ClaseEjecucionHilos getObject() {
		return new ClaseEjecucionHilos();
	}
	
	@Override
	public <E,T,R>void execute(Class<E> clazz,T request,R response) {
		ExecutorService pool= Executors.newSingleThreadExecutor();
		InstanciarClaseService launchClass=InstanciarClase.getObject();
		Stream.of(clazz).map(object->launchClass.instantiationClass(clazz,request,response))
		.map(executeService->new ClaseHilo(executeService)).forEach(pool::execute);
	}
}
