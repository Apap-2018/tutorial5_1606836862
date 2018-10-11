package com.apap.tutorial5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tutorial5.model.FlightModel;
import com.apap.tutorial5.reporsitory.FlightDB;

@Service
@Transactional
public class FlightServiceImpl implements FlightService{
	@Autowired
	private FlightDB flightDB;

	@Override
	public void addFlight(FlightModel flight) {
		flightDB.save(flight);
		
	}

	@Override
	public void deleteFlight(FlightModel flight) {
		flightDB.delete(flight);
		
	}

//	@Override
//	public FlightModel findFlight(Long id) {
//		return flightDB.getOne(id);
//	}

	@Override
	public void updateFlight(String flightNumber, FlightModel flight) {
		FlightModel oldFlight = this.findFlight(flight.getDestination());
		oldFlight.setFlightNumber(flight.getFlightNumber());
		oldFlight.setOrigin(flight.getOrigin());
		oldFlight.setTime(flight.getTime());
	}

	@Override
	public FlightModel findFlight(String flightNumber) {
		return flightDB.findByFlightNumber(flightNumber);
	}

	@Override
	public void deleteFlightById(String flightNumber) {
		FlightModel flight = flightDB.findByFlightNumber(flightNumber);
		flightDB.delete(flight);
		
	}

}