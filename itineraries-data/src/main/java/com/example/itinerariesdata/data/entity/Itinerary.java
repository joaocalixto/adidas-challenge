package com.example.itinerariesdata.data.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@ApiModel
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Itinerary {
	
	@Id
	private Long id;

}
