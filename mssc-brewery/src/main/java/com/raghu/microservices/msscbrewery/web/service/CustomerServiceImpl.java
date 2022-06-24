package com.raghu.microservices.msscbrewery.web.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.raghu.microservices.msscbrewery.web.model.CustomerDto;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Override
	public CustomerDto getCustomerById(UUID id) {
		return CustomerDto.builder().id(UUID.randomUUID()).name("Raghu").build();
	}
	
	
}
