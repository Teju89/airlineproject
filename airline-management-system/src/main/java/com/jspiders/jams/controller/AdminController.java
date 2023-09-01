package com.jspiders.jams.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.jams.dto.AirlineInfoDTO;
import com.jspiders.jams.dto.FareDTO;
import com.jspiders.jams.dto.FlighInfoDTO;
import com.jspiders.jams.dto.FlightDTO;
import com.jspiders.jams.dto.InventoryDTO;
import com.jspiders.jams.service.AirlineService;
import com.jspiders.jams.service.FareService;
import com.jspiders.jams.service.FlightInfoService;
import com.jspiders.jams.service.FlightService;
import com.jspiders.jams.service.InventoryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin")
@Slf4j
public class AdminController {

	private final AirlineService airlineService;

	private final FlightInfoService flightInfoService;

	private final FareService fareService;

	private final InventoryService inventoryService;

	private final FlightService flightService;

	// airlineInfo api's
	@PostMapping("/airlines")
	public ResponseEntity<AirlineInfoDTO> addAirlineInfo(@RequestBody AirlineInfoDTO airlineInfo) {
		log.info("addAirlineInfo method excuted... {} " + airlineInfo.getAirlineName());
		AirlineInfoDTO dto = airlineService.addAirlineInfo(airlineInfo);
		if (dto != null) {
			return ResponseEntity.status(HttpStatus.OK).body(dto);
		}
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

	@DeleteMapping("/airlines/{airlinename}")
	public ResponseEntity<String> removeArilineInfo(@PathVariable("airlinename") String airlineName) {
		if (airlineService.removeAirlineInfo(airlineName) != 0) {
			return ResponseEntity.status(HttpStatus.OK).body("Deleted ");
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Invalid");
	}

	@GetMapping("/airlines")
	public ResponseEntity<List<AirlineInfoDTO>> getAllAirline() {
		return ResponseEntity.status(HttpStatus.FOUND).body(airlineService.getAllAirlines());
	}

	// FlightInfo api's
	@PostMapping("/flightinfo/{aid}")
	public ResponseEntity<Optional<FlighInfoDTO>> addFlightInfo(@RequestBody FlighInfoDTO flighInfo,
			@PathVariable("aid") int airlineId) {
		log.info("addAirlineInfo method excuted... {} " + flighInfo.getFlightNumber());
		return ResponseEntity.status(HttpStatus.OK).body(flightInfoService.addFlightInformation(flighInfo, airlineId));
	}

	@DeleteMapping("/flightinfo/{flightnumber}")
	public ResponseEntity<String> removeFlightInfo(@PathVariable("flightnumber") String flightNumber) {
		if (flightInfoService.removeFlightInfo(flightNumber) != 0) {
			return ResponseEntity.status(HttpStatus.OK).body("Deleted ");
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Invalid");
	}

	@GetMapping("/flightinfos")
	public ResponseEntity<List<FlighInfoDTO>> getAllFlightInfo() {
		return ResponseEntity.status(HttpStatus.FOUND).body(flightInfoService.getAllFlightInfo());
	}

	@PutMapping("/flightinfos")
	public ResponseEntity<FlighInfoDTO> modifyFlightInfo(@RequestBody FlighInfoDTO flighInfo) {
		FlighInfoDTO dto = flightInfoService.modifyFlightInformation(flighInfo);
		if (dto != null) {
			return ResponseEntity.ok(dto);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	@GetMapping("/flightinfos/{airlinename}")
	public ResponseEntity<List<FlighInfoDTO>> getFlightInfoByAirlineName(
			@PathVariable("airlinename") String airlineName) {
		return ResponseEntity.status(HttpStatus.FOUND)
				.body(flightInfoService.getFlightInfoBasedOnAirlineName(airlineName));
	}

	@PostMapping("/fare")
	public ResponseEntity<Integer> addFare(@RequestBody FareDTO fareDTO) {
		log.info("addFare method excuted... {} " + fareDTO.getAmount());
		return ResponseEntity.status(HttpStatus.OK).body(fareService.addFare(fareDTO));
	}

	@PostMapping("/inventory")
	public ResponseEntity<Integer> addInventory(@RequestBody InventoryDTO inventoryDTO) {
		log.info("addInventory method excuted... {} " + inventoryDTO.getCount());
		return ResponseEntity.status(HttpStatus.OK).body(inventoryService.addInventory(inventoryDTO));
	}

	@PostMapping("/flights/{flightinfoid}/{inventoryid}/{fareid}")
	public ResponseEntity<Integer> addFlight(@RequestBody FlightDTO flightDTO, @PathVariable("fareid") int fareId,
			@PathVariable("inventoryid") int inventoryId, @PathVariable("flightinfoid") int flightInfoId) {
		log.info("addFlight method excuted... {} " + flightDTO.getFlightNumber());
		return ResponseEntity.status(HttpStatus.OK)
				.body(flightService.addFlight(flightDTO, flightInfoId, fareId, inventoryId));
	}

}
