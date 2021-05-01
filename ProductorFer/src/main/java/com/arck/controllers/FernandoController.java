package com.arck.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arck.model.Persona;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
public class FernandoController {
	
	@GetMapping("/fernando")
	@HystrixCommand(fallbackMethod = "getDataFallBack")
	public Persona getPersona() {
		
		Persona persona = new Persona();
		persona.setNombre("Fernando");
		persona.setApellidos("Ni idea");
		persona.setTelefono("600000001");
		persona.setYear(39);
		
		return persona;		
	}
	

	public Persona getDataFallBack() {
		
		System.out.println("--- Fallback method ---");

		Persona persona = new Persona();
		persona.setNombre("Error");
		persona.setApellidos("Error");
		persona.setTelefono("Error");
		persona.setYear(0);

		return persona;
		
	}

}
