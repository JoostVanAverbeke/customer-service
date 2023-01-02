package com.example.customerservice;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.customerservice.repositories.CustomerRepository;
import com.example.customerservice.resources.CustomerResource;
import com.example.customerservice.services.HelloService;
import com.example.customerservice.services.ReverseService;

@Configuration
public class JerseyConfiguration {
	
	@Bean
	public CustomerResource customerResource(CustomerRepository customerRepository) {
		return new CustomerResource(customerRepository);
	}
	
	@Bean
	public ResourceConfig config(CustomerResource customerResource) {
		ResourceConfig resourceConfig = new ResourceConfig();
		resourceConfig.register(HelloService.class);
		resourceConfig.register(ReverseService.class);
		resourceConfig.register(customerResource);
		return resourceConfig;
	}

}
