package com.ekart.controller;

import com.ekart.dto.CustomerData;
import com.ekart.exception.*;
import com.ekart.service.CustomerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(value = "api/customers", produces = "application/json")
@CrossOrigin(origins = "*")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping
	public List<CustomerData> findAll() {
		return customerService.findAll();
	}

	@GetMapping("{id}")
	public CustomerData findById(@PathVariable Long id)  {
		return customerService.findById(id);
				

	}

	@PostMapping
	public CustomerData create(@RequestBody CustomerData customerData) {
		return customerService.create(customerData);

	}

	@DeleteMapping("{id}")
	public boolean delete(@PathVariable Long id) {
		return customerService.delete(id);
	}

	@PutMapping("{id}")
	public boolean updateCustomer(@RequestBody CustomerData customerData, @PathVariable("id") Long customerId) {
		return customerService.update(customerData, customerId);

	}

}
