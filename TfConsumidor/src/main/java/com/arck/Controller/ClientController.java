package com.arck.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.arck.model.Persona;

public class ClientController {
	@Autowired
	private DiscoveryClient discoveryClient;

	/*
	 * @Autowired private LoadBalancerClient loadBalancer;
	 */

	public Persona getAlejandra() throws RestClientException, IOException {

		List<ServiceInstance> instances = discoveryClient.getInstances("ZUUL");
		ServiceInstance serviceInstance = instances.get(0);

		// ServiceInstance serviceInstance =
		// loadBalancer.choose("EMPLOYEE-ZUUL-SERVICE");
		
		String baseUrl;
		
		baseUrl = serviceInstance.getUri().toString()+ "/alejandra/alejandra";

		System.out.println("LLAMANDO A.... " + baseUrl);
	

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Persona> response = null;
		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), Persona.class);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return response.getBody();
	}
	
	public Persona getFernando() throws RestClientException, IOException {

		List<ServiceInstance> instances = discoveryClient.getInstances("ZUUL");
		ServiceInstance serviceInstance = instances.get(0);

		// ServiceInstance serviceInstance =
		// loadBalancer.choose("EMPLOYEE-ZUUL-SERVICE");
		
		String baseUrl;
		
		baseUrl = serviceInstance.getUri().toString()+ "/fernando/fernando";

		System.out.println("LLAMANDO A.... " + baseUrl);
	

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Persona> response = null;
		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), Persona.class);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return response.getBody();
	}

	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}

}
