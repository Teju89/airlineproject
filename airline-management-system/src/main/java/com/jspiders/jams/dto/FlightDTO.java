package com.jspiders.jams.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class FlightDTO {

	private String destination;
	private String currentCity;
	private String duration;
	private LocalDate flightDate;
	private String flightNumber;
	private LocalTime flightTime;
	private FlighInfoDTO flightInfo;
	private InventoryDTO inventory;
	private FareDTO fare;
}













