package com.example.itinerariesdata.data.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class City {
	
	@Id
	@GeneratedValue
	public long id;
	public String name;
	
	@OneToMany
    public Set<Connection> connection;

	
}
