package com.codesnippet.ecominventryservice.repository;

import com.codesnippet.ecominventryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}
