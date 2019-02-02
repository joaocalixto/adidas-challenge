package com.example.itinerariesdata.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.itinerariesdata.data.entity.Connection;

public interface ConnectionRepository extends JpaRepository<Connection, Long>{

}
