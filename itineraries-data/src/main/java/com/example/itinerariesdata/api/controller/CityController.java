package com.example.itinerariesdata.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.itinerariesdata.data.entity.City;
import com.example.itinerariesdata.data.entity.FullCity;
import com.example.itinerariesdata.service.StoreCityService;

@RestController
@Validated
@RequestMapping(path = "/data", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CityController {
	
	@Autowired
	StoreCityService storeItineraryService;
	
	@GetMapping
	public String root() {
		return "Service Ruinning - Itinerary Data";
	}
	
	@GetMapping(path = "/city/all")
	public List<City> listPessoas() {
		return storeItineraryService.listAll();
	}
	
	@GetMapping(path = "/city/{cityNname}")
	public FullCity getFullCity(@PathVariable String cityNname) {
		
		FullCity fullCity = storeItineraryService.getFullCity(cityNname);
		
		return fullCity;
	}

}
