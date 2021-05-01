package com.arck;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;

import com.arck.Controller.ClientController;
import com.arck.model.Persona;

@SpringBootApplication
public class TfConsumidorApplication {

	public static void main(String[] args) throws RestClientException, IOException {
		ApplicationContext ctx = SpringApplication.run(
				TfConsumidorApplication.class, args);
		
		ClientController clientController=ctx.getBean(ClientController.class);
		for(int i = 0; i<50;i++) {
			System.out.println("LLamada "+i+"-----"+clientController.getAlejandra().toString());			
		}
		for(int i = 0; i<50;i++) {
			System.out.println("LLamada "+i+"-----"+clientController.getFernando().toString());			
		}
	}

	@Bean
	public  ClientController  clientController()
	{
		return  new ClientController();
	}
}
