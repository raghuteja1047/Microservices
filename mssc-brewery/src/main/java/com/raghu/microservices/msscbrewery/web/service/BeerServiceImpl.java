package com.raghu.microservices.msscbrewery.web.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.raghu.microservices.msscbrewery.web.model.BeerDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
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

	@Override
	public boolean updateBeer(BeerDto beer) {
		// TODO Auto-generated method stub
		saveBeer(beer);
		return true;
	}

	@Override
	public void deleteBeer(UUID beer) {
		log.info("deleteing beer info .. " + beer);
	}
}
