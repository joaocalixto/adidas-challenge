package com.example.itinerariesdata.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Connection {
	
	@Id
	@GeneratedValue
	public long id;
	
	private long city_id_start;
	private long city_id_end;
	
	@OneToOne
	public City start;
	@OneToOne
    public City end;
	
    public double duration;

}
