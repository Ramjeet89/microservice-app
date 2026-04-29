package com.codesnippet.ecominventryservice.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/inventory")
public class InventoryController {

    @GetMapping("/{productId}")
    public String checkInventory(@PathVariable String productId) {
        System.out.println("Checking Inventory for Product ID: " + productId);
        return productId.equals("1") ? "IN STOCK" : " OUT OF STOCK";
    }
}
