package com.example.itinerariesdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.itinerariesdata.data.entity.Connection;
import com.example.itinerariesdata.data.repository.ConnectionRepository;

@Service
public class StoreConnectionServiceImpl implements StoreConnectionService {
	
	@Autowired
	private ConnectionRepository connectionRepository;

	@Override
	public List<Connection> listAll() {
		return connectionRepository.findAll();
	}

}
