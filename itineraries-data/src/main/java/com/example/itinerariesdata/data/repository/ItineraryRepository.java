package com.example.itinerariesdata.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.itinerariesdata.data.entity.Itinerary;

public interface ItineraryRepository extends JpaRepository<Itinerary, Long>{

}
