package com.example.itenerarysearch.domain.webclient;

import java.util.List;

import lombok.Data;

@Data
public class City {
	
	public long id;
	public String name;
	
    public List<Connection> connection;
}
