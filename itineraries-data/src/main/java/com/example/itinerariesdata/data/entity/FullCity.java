package com.example.itinerariesdata.data.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FullCity {
	
	private City city;
	
	private List<Connection> conn;


}
