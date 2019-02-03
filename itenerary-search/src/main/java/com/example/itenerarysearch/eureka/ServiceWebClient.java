package com.example.itenerarysearch.eureka;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.itenerarysearch.domain.webclient.City;
import com.example.itenerarysearch.domain.webclient.Connection;
import com.example.itenerarysearch.domain.webclient.FullCity;

import lombok.extern.java.Log;

@Component
public class ServiceWebClient {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private EurekaService eurekaService;
	
	@Value("${app.itinerarydata.serviceId}")
	private String itineraryDataServiceId;
	
	@Value("${app.itinerarydata.endpoint.city.all}")
	private String itiDataServiceGetAllCities;
	
	@Value("${app.itinerarydata.endpoint.city.fullcity}")
	private String itiDataServiceGetFullCity;
	
	@Value("${app.itinerarydata.endpoint.conn.all}")
	private String itineraryDataGetAllConn;
	
	
	
	public List<City> getAllCities() {
		
		 URI uri = eurekaService.getInstance(itineraryDataServiceId);
	     City[] forObject = restTemplate.getForObject(uri.toString() + itiDataServiceGetAllCities, City[].class);
	     
	     List<City> listCities = Arrays.asList(forObject);
	     
	     return listCities;
	     
	}
	
	public FullCity getFullCity(String name) {
		
		 URI uri = eurekaService.getInstance(itineraryDataServiceId);
		 FullCity fullCity = restTemplate.getForObject(uri.toString() + itiDataServiceGetFullCity + name, FullCity.class);
	     
	     return fullCity;
	     
	}
	
	public List<Connection> getAllConn() {
		
		 URI uri = eurekaService.getInstance(itineraryDataServiceId);
		 String url = uri.toString() + itineraryDataGetAllConn;
		 
		 Connection[] forObject = restTemplate.getForObject(url, Connection[].class);
	     
	     List<Connection> listConnections = Arrays.asList(forObject);
	     
	     return listConnections;
	     
	}

}
