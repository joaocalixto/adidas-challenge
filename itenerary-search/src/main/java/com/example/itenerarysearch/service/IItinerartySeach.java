package com.example.itenerarysearch.service;

import java.util.List;

import com.example.itenerarysearch.domain.SearchResult;

public interface IItinerartySeach {
	
	List<SearchResult> listTravels(String from, String to, String sortBy);

}
