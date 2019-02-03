package com.example.itinerariesdata.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.itinerariesdata.data.entity.City;

public interface CityRepository extends JpaRepository<City, Long>{
	
	List<City> findCityByName(String name);

}
