package com.arck.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arck.model.Persona;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
public class AlejandraController {

	@Autowired
    private Environment environment;

	@GetMapping("/alejandra")
	@HystrixCommand(fallbackMethod = "getDataFallBack")
	public Persona getPersona() {
		String serverPort = environment.getProperty("local.server.port");
		if(serverPort.equals("8013")) {
			throw new RuntimeException(); 
		}
		Persona persona = new Persona();
		persona.setNombre("Alejandra");
		persona.setApellidos("No Se");
		persona.setTelefono("600000000");
		persona.setYear(40);
		System.out.println("Estoy en el puerto: "+serverPort);

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
