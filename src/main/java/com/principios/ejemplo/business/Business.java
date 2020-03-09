package com.principios.ejemplo.business;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.principios.ejemplo.annotations.LogExecutionTime;
import com.principios.ejemplo.data.Dao1;
import com.principios.ejemplo.data.Dao2;

@Service
public class Business {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Dao1 dao1;
	
	@Autowired
	private Dao2 dao2;
	
	public String calcularAlgo(){
		//Business Logic
		String value = dao1.recuperarDatos();
		logger.info("		Dentro del Business - {}", value);
		return value;
	}
	

	@LogExecutionTime
	public String calcularAlgoLento() throws InterruptedException{
		//Business Logic
		Thread.sleep(2000);
		return dao2.recuperarDatos();
	}
}