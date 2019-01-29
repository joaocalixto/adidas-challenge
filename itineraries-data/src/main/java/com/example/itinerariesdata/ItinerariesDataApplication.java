package com.example.itinerariesdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class ItinerariesDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItinerariesDataApplication.class, args);
	}

}

