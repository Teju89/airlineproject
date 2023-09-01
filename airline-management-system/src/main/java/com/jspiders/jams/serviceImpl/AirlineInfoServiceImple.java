package com.jspiders.jams.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jspiders.jams.dto.AirlineInfoDTO;
import com.jspiders.jams.entity.AirlineInfo;
import com.jspiders.jams.repository.AirlineInfoRepository;
import com.jspiders.jams.service.AirlineService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AirlineInfoServiceImple implements AirlineService {

	private final AirlineInfoRepository airlineInfoRepository;

	@Override
	public AirlineInfoDTO addAirlineInfo(AirlineInfoDTO airline) {
		log.info("Airline name {} " + airline.getAirlineName());
		AirlineInfo airlineInfo = airlineInfoRepository
				.save(AirlineInfo.builder().airlineName(airline.getAirlineName()).build());
		return AirlineInfoDTO.builder().airlineName(airlineInfo.getAirlineName()).build();
	}

	@Override
	public int removeAirlineInfo(String name) {
		Optional<AirlineInfo> airline = airlineInfoRepository.findByAirlineName(name);
		if(airline.isPresent()) {
			airlineInfoRepository.delete(airline.get());
			return 1;	
		}
		return 0;
	}

	@Override
	public List<AirlineInfoDTO> getAllAirlines() {
		return airlineInfoRepository.findAll().stream()
				.map(t -> AirlineInfoDTO.builder().airlineName(t.getAirlineName()).airlineId(t.getAirlineId()).build()).toList();
	}

}














