package com.example.itinerariesdata.service;

import java.util.List;

import com.example.itinerariesdata.data.entity.City;
import com.example.itinerariesdata.data.entity.FullCity;

public interface StoreCityService {
	
	List<City> listAll();
	
	void insertTravel(List<City> t);
	
	FullCity getFullCity(String name);

}
