package com.example.itenerarysearch.helper;

import java.util.List;

import com.example.itenerarysearch.graph.City;
import com.example.itenerarysearch.graph.Travel;

public class TravelHelper {
	
	
	public static City getCity(Travel travel, String cityName){
		
		List<City> nodes = travel.getNodes();
		
		for (City city : nodes) {
			if(city.name.equals(cityName)) {
				return city;
			}
		}
		return null;
	}

}
