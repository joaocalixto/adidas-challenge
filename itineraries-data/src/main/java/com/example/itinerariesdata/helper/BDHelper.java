package com.example.itinerariesdata.helper;

import java.util.ArrayList;
import java.util.List;

import com.example.itinerariesdata.data.entity.City;
import com.example.itinerariesdata.data.entity.Connection;
import com.example.itinerariesdata.data.entity.Travel;

public class BDHelper {

	
public static Travel setUp() {
		
		Travel travels = new Travel();
		
		List<City> cities = new ArrayList<City>();
		City recife = new City();
		City rio = new City();
		City brasilia = new City();
		List<Connection> connection = new ArrayList<Connection>();
		
		Connection recifeRio = new Connection();
		recifeRio.setDuration(2);
		recifeRio.setStart(recife);
		recifeRio.setEnd(rio);
		
		Connection recifeBSB = new Connection();
		recifeBSB.setDuration(3);
		recifeBSB.setStart(recife);
		recifeBSB.setEnd(brasilia);
		
		connection.add(recifeRio);
		connection.add(recifeBSB);
		
		List<Connection> connectionBSB = new ArrayList<Connection>();
		Connection bsbRio = new Connection();
		bsbRio.setEnd(rio);
		bsbRio.setStart(brasilia);
		bsbRio.setDuration(1);
		connectionBSB.add(bsbRio );
		brasilia.setConnection(connectionBSB );
		
		recife.setConnection(connection);
		recife.setName("recife");
		brasilia.setName("brasilia");
		rio.setName("rio");
		cities.add(recife );
		cities.add(rio);
		cities.add(brasilia);
		travels.setNodes(cities);
		return travels;
	}
}
