package com.codesnippet.ecomorderservice.client;

import com.codesnippet.ecomorderservice.client.config.InventoryFeignClientConfig;
import com.codesnippet.ecomorderservice.model.Inventory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "inventory-service", url = "http://localhost:8081",
        configuration = InventoryFeignClientConfig.class)
public interface InventoryClient {

    @GetMapping("/inventory/{productId}")
    Inventory getInventory(@PathVariable Long productId);

    @PostMapping("/inventory")
    String updateInventory(@RequestBody Inventory inventory);
}
