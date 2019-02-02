package com.example.itinerariesdata.data.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class City {
	
	@Id
	@GeneratedValue
	public long id;
	public String name;
	
	@OneToMany(targetEntity=Connection.class, fetch=FetchType.EAGER)
    public List<Connection> connection;
}
