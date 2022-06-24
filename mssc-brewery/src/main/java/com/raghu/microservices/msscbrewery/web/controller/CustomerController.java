package com.raghu.microservices.msscbrewery.web.controller;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.raghu.microservices.msscbrewery.web.model.BeerDto;
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
		return ResponseEntity.ok(customerService.getCustomerById(customerId));

	}

	@PostMapping
	public ResponseEntity<CustomerDto> saveCustomer(@RequestBody CustomerDto customer) {
		CustomerDto savedcustomerrDto = customerService.saveCustomer(customer);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "api/v1/customer" + savedcustomerrDto.getId().toString());
		return new ResponseEntity<CustomerDto>(headers, HttpStatus.CREATED);
	}

	@PutMapping("/{customerId}")
	public ResponseEntity<CustomerDto> updateCustomer(@PathVariable UUID customerId,
			@RequestBody CustomerDto customerDto) {
		CustomerDto savedcustomerDto = customerService.getCustomerById(customerId);
		customerService.updateCustomer(savedcustomerDto);
		return new ResponseEntity<CustomerDto>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/{customerId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	/*
	 * Response Status annonation can be used when no headers needs to passed back .
	 * in place of ResponseEntity as return type .
	 */
	public void deletecustomer(@PathVariable UUID id) {

		customerService.deleteCustomer(id);

	}

}
