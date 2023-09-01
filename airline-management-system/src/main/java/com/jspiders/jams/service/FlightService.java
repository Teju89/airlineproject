package com.jspiders.jams.service;

import java.util.List;

import com.jspiders.jams.dto.FlightDTO;

public interface FlightService {

	int addFlight(FlightDTO flightDTO, int flightInfoId, int fareId, int inventoryId);
	
	List<FlightDTO> searchByFlightNumber(String FlightNumber);

	List<FlightDTO> searchByCurrentCityAndDestinationAndDate(FlightDTO flightDTO);
	
	List<FlightDTO> searchByCurrentCityAndDestinationAndDateAndTime(FlightDTO flightDTO);
	
}
