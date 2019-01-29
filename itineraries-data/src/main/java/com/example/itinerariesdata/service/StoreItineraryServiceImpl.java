package com.example.itinerariesdata.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.itinerariesdata.data.entity.Itinerary;
import com.example.itinerariesdata.data.repository.ItineraryRepository;

@Service
public class StoreItineraryServiceImpl implements StoreItineraryService {
	
	private ItineraryRepository itineraryRepository;

	@Override
	public List<Itinerary> listAll() {
		return itineraryRepository.findAll();
	}

}
