package com.example.itinerariesdata.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.itinerariesdata.data.entity.City;
import com.example.itinerariesdata.data.entity.Connection;
import com.example.itinerariesdata.data.entity.FullCity;
import com.example.itinerariesdata.data.repository.CityRepository;
import com.example.itinerariesdata.data.repository.ConnectionRepository;

@Service
public class StoreCityServiceImpl implements StoreCityService {
	
	@Autowired
	private CityRepository itineraryRepository;
	
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
			
			Set<Connection> cityConnection = city.getConnection();
			
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

	@Override
	public FullCity getFullCity(String name) {
		
		List<City> findCityByName = itineraryRepository.findCityByName(name);
		
		if(findCityByName == null) {
			return null;
		}
		
		City city = findCityByName.get(0);
		
		Set<Connection> cityConnections = connectionRepository.findConnectionBycityIdStart(city.getId());
		
		FullCity f = new FullCity();
		
		f.setCity(city);
		List<Connection> mainList = new ArrayList<Connection>();
		mainList.addAll(cityConnections);
		f.setConn(mainList);
		
		return f;
	}

}
