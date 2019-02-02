package com.example.itenerarysearch.service;

import java.util.List;

import com.example.itenerarysearch.graph.Travel;

public interface IItinerartySeach {
	
	List<Travel> listTravels(String from, String to);

}
