package com.example.itinerariesdata.data.entity;

import java.util.List;

import lombok.Data;

@Data
public class Travel {
	
	int id;
    List<City> nodes;
}
