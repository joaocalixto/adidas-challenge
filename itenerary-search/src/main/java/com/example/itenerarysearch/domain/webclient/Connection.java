package com.example.itenerarysearch.domain.webclient;

import lombok.Data;

@Data
public class Connection {
	
	public long id;
	
	private long city_id_start;
	private long city_id_end;
	
	public City start;
    public City end;
	
    public double duration;
    
    private boolean visited;

}
