package com.raghu.microservices.msscbrewery.web.service;

import java.util.UUID;

import com.raghu.microservices.msscbrewery.web.model.BeerDto;

public interface BeerService {
	BeerDto getBeerById(UUID id);

	BeerDto saveBeer(BeerDto beer);
	
	boolean updateBeer(BeerDto beer);

	void deleteBeer(UUID beer);
}
