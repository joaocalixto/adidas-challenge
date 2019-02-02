package com.example.itinerariesdata.service;

import java.util.List;

import com.example.itinerariesdata.data.entity.City;

public interface StoreItineraryService {
	
	List<City> listAll();
	
	void insertTravel(List<City> t);

}
