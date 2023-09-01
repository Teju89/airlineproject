package com.jspiders.jams.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.jams.dto.FlightDTO;
import com.jspiders.jams.dto.UserDTO;
import com.jspiders.jams.service.FlightService;
import com.jspiders.jams.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	private final FlightService flightService;

	private final UserService userService;

	@GetMapping("/flights/{flightNumber}")
	public ResponseEntity<List<FlightDTO>> getFlightByFlightNumber(@PathVariable("flightNumber") String FlightNumber) {
		List<FlightDTO> flightDto = flightService.searchByFlightNumber(FlightNumber);
		log.info("flight info {}" + FlightNumber);
//		 log.info("flight number " + flightDto.get(0).getFlightNumber());
		return ResponseEntity.ok(flightDto);
	}

	@GetMapping("/flights")
	public ResponseEntity<List<FlightDTO>> getFlightByCurrentCityDestinationDate(@RequestBody FlightDTO flightDTO) {
		List<FlightDTO> flightDto = flightService.searchByCurrentCityAndDestinationAndDate(flightDTO);
		return ResponseEntity.ok(flightDto);
	}

	@GetMapping("/searchflights")
	public ResponseEntity<List<FlightDTO>> getFlightByCurrentCityDestinationDateTime(@RequestBody FlightDTO flightDTO) {
		List<FlightDTO> flightDto = flightService.searchByCurrentCityAndDestinationAndDateAndTime(flightDTO);
		return ResponseEntity.ok(flightDto);
	}

	@PostMapping("/register")
	public ResponseEntity<Long> registration(UserDTO user) {
		long record = userService.register(user);
		if (record > 0) {
			return ResponseEntity.status(HttpStatus.CREATED).body(record);
		}
		return ResponseEntity.status(HttpStatus.OK).body(0L);
	}

	@PostMapping("/login/{username}/{passwor}")
	public ResponseEntity<String> login(String username, String password) {
		UserDTO dto = userService.login(username, password);
		if (dto != null) {
			return ResponseEntity.ok("Login Successfull!!!");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enter valid credentials");
	}

}
















