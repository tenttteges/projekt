package com.example.demo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Customer;

@RepositoryRestResource(path="members")
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	public List<Customer> findAllByOrderByLastNameAsc();
	
	public List<Customer> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name, String lName);
	
}
