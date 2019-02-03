package com.example.itenerarysearch.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchResult {
	private String routes = "";
	private double duration;
	private List<String> citiesVisited = new ArrayList<String>();
}