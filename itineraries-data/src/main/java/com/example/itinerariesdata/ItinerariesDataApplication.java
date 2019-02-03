package com.example.itinerariesdata;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.itinerariesdata.data.entity.Travel;
import com.example.itinerariesdata.helper.BDHelper;
import com.example.itinerariesdata.service.StoreCityService;


@EnableDiscoveryClient
@SpringBootApplication
public class ItinerariesDataApplication {
	
	@Autowired
	StoreCityService storeItineraryService;

	public static void main(String[] args) {
		SpringApplication.run(ItinerariesDataApplication.class, args);
	}
	
	@PostConstruct
	public void init() {
		Travel setUp = BDHelper.setUp();
		storeItineraryService.insertTravel(setUp.getNodes());
	}

}

