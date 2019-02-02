package com.example.itinerariesdata.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.itinerariesdata.data.entity.City;

public interface ItineraryRepository extends JpaRepository<City, Long>{

}
