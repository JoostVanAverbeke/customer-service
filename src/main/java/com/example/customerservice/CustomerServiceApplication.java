package com.example.customerservice;


import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.customerservice.models.Customer;
import com.example.customerservice.repositories.CustomerRepository;

@SpringBootApplication
public class CustomerServiceApplication {

	@Bean
	ApplicationRunner data(CustomerRepository customerRepository) {
		return args -> Stream.of("A", "B", "C").forEach(
				x -> customerRepository.save(new Customer(null, x)));
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

}
