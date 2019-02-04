package com.example.itenerarysearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.netflix.ribbon.eureka.EurekaRibbonClientConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.itenerarysearch.domain.SearchResult;
import com.example.itenerarysearch.service.IItinerartySeach;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RibbonClients(defaultConfiguration = {EurekaRibbonClientConfiguration.class})
@Api(tags = { "itinerary-search" })
public class ItinerarySearchController {
	
	@Autowired
	IItinerartySeach itineraryService;
	
	@ApiOperation(value = "Return best itinerary")
	@GetMapping("itinerary")
	public List<SearchResult> getItinerary(@RequestParam("from") String from, @RequestParam("to") String to, @RequestParam(value = "",required=false, name="sortBy") String sortBy){
		return itineraryService.listTravels(from, to, sortBy);
	}

}
