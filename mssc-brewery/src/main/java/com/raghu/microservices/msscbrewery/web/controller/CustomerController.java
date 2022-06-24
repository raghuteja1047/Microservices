package com.raghu.microservices.msscbrewery.web.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raghu.microservices.msscbrewery.web.model.CustomerDto;
import com.raghu.microservices.msscbrewery.web.service.CustomerService;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

	CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	@GetMapping("/{customerId}")
	public ResponseEntity<CustomerDto> getCustomerById(@PathVariable UUID customerId) {
		return  ResponseEntity.ok(customerService.getCustomerById(customerId));

	}
	
}
