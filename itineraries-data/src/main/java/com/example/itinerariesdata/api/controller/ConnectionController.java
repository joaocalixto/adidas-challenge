package com.example.itinerariesdata.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.itinerariesdata.data.entity.Connection;
import com.example.itinerariesdata.service.StoreConnectionService;

@RestController
@Validated
@RequestMapping(path = "/data", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ConnectionController {
	
	@Autowired
	StoreConnectionService storeConnService;
	
	@GetMapping(path = "/conn/all")
	public List<Connection> listConnection() {
		return storeConnService.listAll();
	}
}
