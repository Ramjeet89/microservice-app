package com.codesnippet.ecominventryservice.service;

import com.codesnippet.ecominventryservice.model.Inventory;
import com.codesnippet.ecominventryservice.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    InventoryRepository inventoryRepository;

    public Inventory checkStock(Long productId) {
        Optional<Inventory> inventory = inventoryRepository.findById(productId);
        return inventory.get();
    }

    public String addProduct(Inventory inventory) {
         inventoryRepository.save(inventory);
         return "Product Added";
    }

    public String updateProduct(Inventory inventory) {
        inventoryRepository.save(inventory);
        return "Product Updated";
    }

    public String deleteProduct(Long productId) {
        inventoryRepository.deleteById(productId);
        return "Product Deleted";
    }
}
