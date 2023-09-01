package com.jspiders.jams.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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
public class FlightInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int flightId;
	
	@Column(unique = true, nullable = false)
	private String flightNumber;
	
	@Column(nullable = false)
	private String flightType;
	
	@Column(nullable = false)
	private int noOfSeats;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "airlineId")
	private AirlineInfo airlineInfo;
	
	
	@OneToOne(cascade = CascadeType.ALL, fetch =  FetchType.EAGER, mappedBy = "flightInfo")
	private Flight flight;
}




















