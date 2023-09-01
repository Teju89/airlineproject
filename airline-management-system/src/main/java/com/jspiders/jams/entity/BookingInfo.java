package com.jspiders.jams.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
@Entity
public class BookingInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookingId;
	
	@Column(nullable = false)
	private LocalDate bookingDate;
	
	@Column(nullable = false)
	private String destination;
	
	@Column(nullable = false)
	private double fare;
	
	@Column(nullable = false)
	private LocalDate flightDate;
	
	@Column(unique = true, nullable = false)
	private String flightNumber;
	
	@Column(nullable = false)
	private LocalTime flightTime;
	
	@Column(nullable = false)
	private String currentCity;
	
	
	private String status;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="bookingInfo")
	private List<Passenger> passengers;
	
}














