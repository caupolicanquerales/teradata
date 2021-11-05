package com.capo.teradata.service;

public interface EjecucionHilosService {
	public <E,T,R> void execute(Class<E>objects,T request,R response);
}
