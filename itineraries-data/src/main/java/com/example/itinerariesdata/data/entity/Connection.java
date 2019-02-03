package com.example.itinerariesdata.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Connection {
	
	@Id
	@GeneratedValue
	public long id;
	
	@OneToOne
	@JoinColumn(name = "city_id_start")
	public City start;
	
	@OneToOne
	@JoinColumn(name = "city_id_end")
    public City end;
	
    public double duration;


}
