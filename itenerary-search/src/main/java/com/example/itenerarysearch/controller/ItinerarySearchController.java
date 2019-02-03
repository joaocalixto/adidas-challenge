package com.example.itenerarysearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.netflix.ribbon.eureka.EurekaRibbonClientConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.itenerarysearch.domain.SearchResult;
import com.example.itenerarysearch.domain.webclient.Connection;
import com.example.itenerarysearch.eureka.ServiceWebClient;
import com.example.itenerarysearch.service.IItinerartySeach;


@RestController
@RibbonClients(defaultConfiguration = {EurekaRibbonClientConfiguration.class})
public class ItinerarySearchController {
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	@Autowired
	ServiceWebClient serviceWebClient;
	
	@Autowired
	IItinerartySeach itineraryService;
	
	@RequestMapping("services-instances/{appName}")
	public List<ServiceInstance> listSomething(@PathVariable String appName){
		return discoveryClient.getInstances(appName);
	}
	
	@RequestMapping("conn/all")
	public List<Connection> getAllConnections(){
		return serviceWebClient.getAllConn();
	}
	
	@RequestMapping("itinerary")
	public List<SearchResult> getItinerary(@RequestParam("from") String from, @RequestParam("to") String to, @RequestParam(value = "",required=false, name="sortBy") String sortBy){
		return itineraryService.listTravels(from, to, sortBy);
	}

}
