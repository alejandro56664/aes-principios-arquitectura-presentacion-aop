package com.principios.ejemplo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.principios.ejemplo.business.Business;

@RestController
@RequestMapping("/business1")
public class IndexController {
	
	@Autowired
	private Business business1;

	
    @GetMapping(value = "/calcularAlgo")
    public String business1CalcularAlgo(){
        return business1.calcularAlgo();
    }
    
    @GetMapping(value = "/calcularAlgoLento")
    public String business1CalcularAlgoLento() throws InterruptedException{
        return business1.calcularAlgoLento();
    }
}