package com.raghu.microservices.msscbrewery.web.service;

import java.util.UUID;

import com.raghu.microservices.msscbrewery.web.model.CustomerDto;

public interface CustomerService {

	CustomerDto getCustomerById(UUID id);

	CustomerDto saveCustomer(CustomerDto customer);

	boolean updateCustomer(CustomerDto customer);

	void deleteCustomer(UUID beer);
}
