package com.jspiders.jams.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspiders.jams.entity.FlightInfo;

public interface FlightInfoRepository extends JpaRepository<FlightInfo, Integer>{

	Optional<FlightInfo> findByFlightNumber(String flightNumber);
}
