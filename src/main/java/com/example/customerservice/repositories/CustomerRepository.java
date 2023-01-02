/**
 * 
 */
package com.example.customerservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.customerservice.models.Customer;

/**
 * @author joost
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
