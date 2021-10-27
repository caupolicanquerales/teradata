package com.capo.teradata.threadEjecucion;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.capo.teradata.service.EjecucionHilosService;
import com.capo.teradata.service.ExecuteService;

public class ClaseEjecucionHilos implements EjecucionHilosService{
	
	@Override
	public void execute(ExecuteService... objects) {
		List<Runnable> threads=Stream.of(objects).map(object->new ClaseHilo(object)).collect(Collectors.toList());
		ExecutorService pool= Executors.newFixedThreadPool(5);
		threads.stream().limit(5).forEach(thread->{
			pool.execute(thread);
		});
	}
}
