package com.jspiders.jams.serviceImpl;

import org.springframework.stereotype.Service;

import com.jspiders.jams.dto.FareDTO;
import com.jspiders.jams.entity.Fare;
import com.jspiders.jams.repository.FareRepository;
import com.jspiders.jams.service.FareService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FareServiceImpl implements FareService {

	private final FareRepository fareRepository;

	@Override
	public int addFare(FareDTO fare) {
		return fareRepository.save(Fare.builder().amount(fare.getAmount()).currency(fare.getCurrency()).build())
				.getFareId();
	}

}
