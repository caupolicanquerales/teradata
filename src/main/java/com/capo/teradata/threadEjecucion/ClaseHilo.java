package com.capo.teradata.threadEjecucion;

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
			objeto.execute();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
