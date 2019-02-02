package com.example.itinerariesdata.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.itinerariesdata.data.entity.City;
import com.example.itinerariesdata.data.entity.Connection;
import com.example.itinerariesdata.data.entity.Travel;
import com.example.itinerariesdata.helper.BDHelper;
import com.example.itinerariesdata.service.StoreConnectionService;
import com.example.itinerariesdata.service.StoreItineraryService;

@RestController
@Validated
@RequestMapping(path = "/data", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ItineraryController {
	
	StoreItineraryService storeItineraryService;
	
	@Autowired
	StoreConnectionService storeConnService;
	
	@Autowired
	public ItineraryController(StoreItineraryService storePessoaService) {
		this.storeItineraryService = storePessoaService;
	}
	
	@GetMapping
	public String root() {
		return "Service Ruinning - Itinerary Data";
	}
	
	@GetMapping(path = "/city/all")
	public List<City> listPessoas() {
		return storeItineraryService.listAll();
	}
	
	@GetMapping(path = "/conn/all")
	public List<Connection> listConnection() {
		return storeConnService.listAll();
	}
	
	@GetMapping(path = "/init")
	public void init() {
		
		Travel setUp = BDHelper.setUp();
		storeItineraryService.insertTravel(setUp.getNodes());
	}

}
