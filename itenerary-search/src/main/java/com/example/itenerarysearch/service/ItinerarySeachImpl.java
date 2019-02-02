package com.example.itenerarysearch.service;

import java.util.ArrayList;
import java.util.List;

import com.example.itenerarysearch.graph.City;
import com.example.itenerarysearch.graph.Connection;
import com.example.itenerarysearch.graph.Return;
import com.example.itenerarysearch.graph.Travel;
import com.example.itenerarysearch.helper.TravelHelper;

public class ItinerarySeachImpl implements IItinerartySeach {

	static Travel travel = setup();
	static Return ret = new Return();
	static List<Return> listRet = new ArrayList<Return>();
	
	@Override
	public List<Travel> listTravels(String from, String to) {
		
		City city = TravelHelper.getCity(travel, "wrew");
		if(city == null) {
			return null;
		}
		
		buildItinerary("recife", "rio", 0);
		
		
		return null;
	}
	
	public static void main(String[] args) {
		
		buildItinerary("recife", "rio", 0);
		
		System.out.println(listRet.toString());
		
	}

	public static void buildItinerary(String from, String to, double sum){
		if(sum == 0 ) {
			sum+=sum;
		}
		ret.setDuration(ret.getDuration()+ sum);
		
		if(to.equals(from)) {
			System.out.println(from);
			ret.setRoutes(ret.getRoutes() + from);
			listRet.add(ret);
			String r = ret.getRoutes();
			r = r.replaceAll(from, "");
			double dur = ret.getDuration()- sum;
			ret = new Return();
			ret.setDuration(dur);
			ret.setRoutes(r);
			return;
		}
		
		ret.setRoutes(ret.getRoutes() + from +" -> ");
		
		City city = TravelHelper.getCity(travel, from);
		
		List<Connection> connectionList = city.getConnection();
		
		for (Connection connection : connectionList) {
			
			double duration = connection.getDuration();
			City end = connection.getEnd();
			
			buildItinerary(end.getName(), to, duration);
		}
	}
	

	private static Travel setup() {
		
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
