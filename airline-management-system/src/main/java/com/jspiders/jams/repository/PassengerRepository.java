package com.jspiders.jams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspiders.jams.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer>{

}
