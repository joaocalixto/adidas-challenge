package com.example.itinerariesdata.helper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		City salvador = new City();
		Set<Connection> connection = new HashSet<Connection>();
		
		Connection recifeRio = new Connection();
		recifeRio.setDuration(3);
		recifeRio.setStart(recife);
		recifeRio.setEnd(rio);
		
		Connection recifeBSB = new Connection();
		recifeBSB.setDuration(3);
		recifeBSB.setStart(recife);
		recifeBSB.setEnd(brasilia);
		
		Connection recifeSAL = new Connection();
		recifeSAL.setDuration(1);
		recifeSAL.setStart(recife);
		recifeSAL.setEnd(salvador);
		
		connection.add(recifeRio);
		connection.add(recifeBSB);
		connection.add(recifeSAL);
		
		Set<Connection> connectionBSB = new HashSet<Connection>();
		Connection bsbRio = new Connection();
		bsbRio.setEnd(rio);
		bsbRio.setStart(brasilia);
		bsbRio.setDuration(1);
		connectionBSB.add(bsbRio);
		brasilia.setConnection(connectionBSB);
		
		Set<Connection> connectionSAL = new HashSet<Connection>();
		Connection salRio = new Connection();
		salRio.setEnd(rio);
		salRio.setStart(salvador);
		salRio.setDuration(1);
		connectionSAL.add(salRio);
		salvador.setConnection(connectionSAL);
		
		recife.setConnection(connection);
		recife.setName("recife");
		brasilia.setName("brasilia");
		rio.setName("rio");
		salvador.setName("salvador");
		cities.add(recife );
		cities.add(rio);
		cities.add(brasilia);
		cities.add(salvador);
		travels.setNodes(cities);
		return travels;
	}
}
