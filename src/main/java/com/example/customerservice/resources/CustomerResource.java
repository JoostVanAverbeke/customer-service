package com.example.customerservice.resources;

/**
 * 
 */

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.customerservice.models.Customer;
import com.example.customerservice.repositories.CustomerRepository;

/**
 * @author joost
 *
 */
@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {
	private final CustomerRepository customerRepository;
	
	public CustomerResource(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@GET
	public Collection<Customer> customers() {
		return customerRepository.findAll();
	}
	
	@GET
	@Path("/{id}")
	public Customer byId(@PathParam("id") Long id) {
		return customerRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException(
						"Couldn't find customer with id #" +  id + "!"));
		
	}

}