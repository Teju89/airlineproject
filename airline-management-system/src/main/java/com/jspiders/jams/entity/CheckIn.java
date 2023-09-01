package com.jspiders.jams.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class CheckIn {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int checkInId;
	
	@Column(unique = true, nullable = false)
	private String seatNumber;
	
	@Column(unique = true, nullable = false)
	private String gateNumber;
	
	@OneToOne(cascade = CascadeType.ALL, fetch =  FetchType.EAGER, mappedBy = "checkIn")
	private Passenger passenger;
}
