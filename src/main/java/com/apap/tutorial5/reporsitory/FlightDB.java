package com.apap.tutorial5.reporsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.tutorial5.model.FlightModel;

@Repository
public interface FlightDB extends JpaRepository<FlightModel, Long>{
	FlightModel findByFlightNumber(String flightNumber);
	
}