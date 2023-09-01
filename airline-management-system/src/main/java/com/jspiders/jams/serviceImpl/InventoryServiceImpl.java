package com.jspiders.jams.serviceImpl;

import org.springframework.stereotype.Service;

import com.jspiders.jams.dto.InventoryDTO;
import com.jspiders.jams.entity.Inventory;
import com.jspiders.jams.repository.InventoryRepository;
import com.jspiders.jams.service.InventoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

	private final InventoryRepository inventoryRepository;

	@Override
	public int addInventory(InventoryDTO inventory) {
		return inventoryRepository.save(Inventory.builder().count(inventory.getCount()).build()).getInventoryId();
	}

}
