package com.jspiders.jams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspiders.jams.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer>{

}
