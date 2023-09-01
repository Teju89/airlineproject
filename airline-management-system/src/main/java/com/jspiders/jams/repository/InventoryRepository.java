package com.jspiders.jams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspiders.jams.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer>{

}
