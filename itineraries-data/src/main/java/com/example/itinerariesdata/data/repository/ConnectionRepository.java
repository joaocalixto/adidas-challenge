package com.example.itinerariesdata.data.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.itinerariesdata.data.entity.Connection;

public interface ConnectionRepository extends JpaRepository<Connection, Long>{
	
	@Query("select c from Connection c where c.start.id = ?#{[0]}")
	Set<Connection> findConnectionBycityIdStart(long id);
	
}
