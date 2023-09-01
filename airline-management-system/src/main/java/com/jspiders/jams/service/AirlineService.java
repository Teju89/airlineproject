package com.jspiders.jams.service;

import java.util.List;

import com.jspiders.jams.dto.AirlineInfoDTO;

public interface AirlineService {

	AirlineInfoDTO addAirlineInfo(AirlineInfoDTO airline);
	
	int removeAirlineInfo(String name);
	
	List<AirlineInfoDTO> getAllAirlines();
}
