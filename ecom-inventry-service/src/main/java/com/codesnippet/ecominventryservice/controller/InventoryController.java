package com.codesnippet.ecominventryservice.controller;

import com.codesnippet.ecominventryservice.model.Inventory;
import com.codesnippet.ecominventryservice.service.InventoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService service) {
        this.inventoryService = service;
    }
    
    @GetMapping("/{productId}")
    public Inventory checkInventory(@PathVariable Long productId) throws InterruptedException {
       // Thread.sleep(15000);
        return inventoryService.checkStock(productId);
    }

    @PostMapping
    public String addProduct(@RequestBody Inventory inventory) {
        return inventoryService.addProduct(inventory);
    }

    @PutMapping
    public String updateProduct(@RequestBody Inventory inventory) {
        return inventoryService.updateProduct(inventory);
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable Long productId) {
        return inventoryService.deleteProduct(productId);
    }
}
