package com.example.itinerariesdata.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.itinerariesdata.data.entity.Itinerary;
import com.example.itinerariesdata.service.StoreItineraryService;

@Controller
@CrossOrigin(maxAge = 3600)
@RestController
@Validated
@RequestMapping(path = "/api/v1/rest/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ItineraryController {
	
	@Autowired
	StoreItineraryService storeItineraryService;
	
	@GetMapping(path = "/")
	public String root() {
		return "Service Ruinning";
	}
	
	@GetMapping(path = "/itineraries")
	public List<Itinerary> listPessoas() {
		return storeItineraryService.listAll();
	}

}
