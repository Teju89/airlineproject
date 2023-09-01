package com.jspiders.jams.dto;

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
public class FlighInfoDTO {

	private String flightNumber;
	private String flightType;
	private int noOfSeats;
//	private FlightDTO flight;
	private AirlineInfoDTO airlineInfo;
}
