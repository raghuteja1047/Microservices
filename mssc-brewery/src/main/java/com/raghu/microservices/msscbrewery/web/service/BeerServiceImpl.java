package com.raghu.microservices.msscbrewery.web.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.raghu.microservices.msscbrewery.web.model.BeerDto;

@Service
public class BeerServiceImpl implements BeerService {
	@Override
	public BeerDto getBeerById(UUID id) {
		return new BeerDto().builder().id(UUID.randomUUID()).beerName("Galaxy  cat").beerStyle("Pale Ale").build();
	}

	@Override
	public BeerDto saveBeer(BeerDto beer) {
		beer = beer.builder().id(UUID.randomUUID()).build();
		return beer;
	}
}
