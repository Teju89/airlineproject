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
public class PassengerDTO {

	private String emailAddress;
	private String firstName;
	private String gender;
	private String lastName;
	private long mobileNumber;
	private BookingInfoDTO bookingInfo;
	private CheckInDTO checkIn;
}
