package com.jspiders.jams.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspiders.jams.entity.AirlineInfo;

public interface AirlineInfoRepository extends JpaRepository<AirlineInfo, Integer>{

	Optional<AirlineInfo> findByAirlineName(String name);
}
