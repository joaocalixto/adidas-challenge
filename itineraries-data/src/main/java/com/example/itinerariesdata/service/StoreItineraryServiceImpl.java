package com.example.itinerariesdata.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.itinerariesdata.data.entity.City;
import com.example.itinerariesdata.data.entity.Connection;
import com.example.itinerariesdata.data.repository.ConnectionRepository;
import com.example.itinerariesdata.data.repository.ItineraryRepository;

@Service
public class StoreItineraryServiceImpl implements StoreItineraryService {
	
	@Autowired
	private ItineraryRepository itineraryRepository;
	
	@Autowired
	private ConnectionRepository connectionRepository;

	@Override
	public List<City> listAll() {
		return itineraryRepository.findAll();
	}

	@Override
	public void insertTravel(List<City> travel) {
		
		List<Connection> listConnection = new ArrayList<Connection>();
		for (City city : travel) {
			
			List<Connection> cityConnection = city.getConnection();
			
			if(cityConnection != null) {
				for (Connection con : cityConnection) {
					listConnection.add(con);
				}
			}
			
			city.setConnection(null);
			itineraryRepository.save(city);	
		}
		
		connectionRepository.saveAll(listConnection);
	}

}
