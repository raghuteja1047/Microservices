package com.raghu.microservices.msscbrewery.web.controller;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.ServerRequest.Headers;

import com.raghu.microservices.msscbrewery.web.model.BeerDto;
import com.raghu.microservices.msscbrewery.web.service.BeerService;

@RestController
@RequestMapping("api/v1/beer")
public class BeerController {

	private BeerService beerService;

	public BeerController(BeerService beerService) {
		super();
		this.beerService = beerService;
	}

	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDto> getBeer(@PathVariable UUID beerId) {
		return new ResponseEntity<BeerDto>(beerService.getBeerById(beerId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<BeerDto> addBeer(BeerDto beer){
		BeerDto  savedBeerDto = beerService.saveBeer(beer);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "api/v1/beer"+savedBeerDto.getId().toString());
		return new ResponseEntity<BeerDto>(headers,HttpStatus.CREATED);
	}
}
