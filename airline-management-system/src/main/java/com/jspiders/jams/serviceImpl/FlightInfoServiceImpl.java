package com.jspiders.jams.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jspiders.jams.dto.AirlineInfoDTO;
import com.jspiders.jams.dto.FlighInfoDTO;
import com.jspiders.jams.entity.FlightInfo;
import com.jspiders.jams.repository.AirlineInfoRepository;
import com.jspiders.jams.repository.FlightInfoRepository;
import com.jspiders.jams.service.FlightInfoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FlightInfoServiceImpl implements FlightInfoService {

	private final FlightInfoRepository flightInfoRepository;

	private final AirlineInfoRepository airlineInfoRepository;

	@Override
	public Optional<FlighInfoDTO> addFlightInformation(FlighInfoDTO flightInfo, int airlineId) {

		FlightInfo flightInfoDB = flightInfoRepository
				.save(FlightInfo.builder().flightNumber(flightInfo.getFlightNumber())
						.flightType(flightInfo.getFlightType()).noOfSeats(flightInfo.getNoOfSeats())
						.airlineInfo(airlineInfoRepository.findById(airlineId).get()).build());

		return Optional.ofNullable(FlighInfoDTO.builder().flightNumber(flightInfoDB.getFlightNumber())
				.flightType(flightInfoDB.getFlightType()).noOfSeats(flightInfoDB.getNoOfSeats())
				.airlineInfo(AirlineInfoDTO.builder().airlineName(flightInfoDB.getAirlineInfo().getAirlineName())
						.airlineId(flightInfoDB.getAirlineInfo().getAirlineId()).build())
				.build());

	}

	@Override
	public int removeFlightInfo(String flightNumber) {
		Optional<FlightInfo> flightInfo = flightInfoRepository.findByFlightNumber(flightNumber);
		if (flightInfo.isPresent()) {
			flightInfoRepository.delete(flightInfo.get());
			return 1;
		}
		return 0;
	}

	@Override
	public FlighInfoDTO modifyFlightInformation(FlighInfoDTO dto) {
		Optional<FlightInfo> findBy = flightInfoRepository.findByFlightNumber(dto.getFlightNumber());
		if (findBy.isPresent()) {
			FlightInfo fromDB = findBy.get();
			fromDB.setFlightType(dto.getFlightType());
			fromDB.setNoOfSeats(dto.getNoOfSeats());

			FlightInfo updated = flightInfoRepository.save(fromDB);
			return FlighInfoDTO.builder().flightNumber(updated.getFlightNumber()).flightType(updated.getFlightType())
					.noOfSeats(updated.getNoOfSeats()).build();
		}
		return null;
	}

	@Override
	public List<FlighInfoDTO> getAllFlightInfo() {

		return flightInfoRepository.findAll().stream()
				.map(t -> FlighInfoDTO.builder().flightNumber(t.getFlightNumber()).flightType(t.getFlightType())
						.noOfSeats(t.getNoOfSeats())
						.airlineInfo(AirlineInfoDTO.builder().airlineId(t.getAirlineInfo().getAirlineId())
								.airlineName(t.getAirlineInfo().getAirlineName()).build())
						.build())
				.toList();
	}

	@Override
	public List<FlighInfoDTO> getFlightInfoBasedOnAirlineName(String airlineName) {
		return getAllFlightInfo().stream()
				.filter(t -> t.getAirlineInfo().getAirlineName().equalsIgnoreCase(airlineName))
				.toList();
	}

}
