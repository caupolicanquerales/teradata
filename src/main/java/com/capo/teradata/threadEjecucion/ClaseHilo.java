package com.capo.teradata.threadEjecucion;

import java.util.Map;

import com.capo.teradata.service.ExecuteService;

public class ClaseHilo implements Runnable{
	
	private ExecuteService objeto;
	
	public ClaseHilo(ExecuteService objeto) {
		this.objeto=objeto;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
			Map<String,String> mapValue=objeto.execute();
			System.out.println(mapValue);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
