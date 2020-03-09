package com.principios.ejemplo.data;
import org.springframework.stereotype.Repository;

@Repository
public class Dao1 {
	
	public String recuperarDatos(){
		return "Hola desde Dao1";
	}

}