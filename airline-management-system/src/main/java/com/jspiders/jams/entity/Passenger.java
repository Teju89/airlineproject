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
public class Passenger {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long passengerId;
	
	@Column(nullable = false, unique = true)
	private String emailAddress;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String gender;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column(nullable = false, unique = true)
	private long mobileNumber;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "bookingInfo")
	private BookingInfo bookingInfo;
	
	@OneToOne(cascade = CascadeType.ALL, fetch =  FetchType.EAGER)
	@JoinColumn(name = "checkInId")
	private CheckIn checkIn;
}




















