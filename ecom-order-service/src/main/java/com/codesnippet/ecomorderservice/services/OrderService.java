package com.codesnippet.ecomorderservice.services;

import com.codesnippet.ecomorderservice.client.InventoryClient;
import com.codesnippet.ecomorderservice.model.Inventory;
import com.codesnippet.ecomorderservice.exception.MyCustomException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    private final RestTemplate restTemplate;

    private final InventoryClient inventoryClient;

    private final RestClient restClient;

    public OrderService(RestTemplate restTemplate, InventoryClient inventoryClient, RestClient restClient) {
        this.restTemplate = restTemplate;
        this.inventoryClient = inventoryClient;
        this.restClient = restClient;
    }

    public String placeOrder(Long productId) {
        //Rest Template Example
        /*
            String response = restTemplate.getForObject(
                    "http://localhost:8081/inventory/" + productId,
                    String.class
            );
        */

        // Simple RestCleint Example Get

//        ResponseEntity<Inventory> entity = restClient.get()
//                .uri("http://localhost:8081/inventory/" + productId)
//                .retrieve()
//                .onStatus(HttpStatusCode::is4xxClientError, ((request, response) -> {
//                    throw new MyCustomException(response.getStatusCode(), response.getHeaders());
//                }))
//                .toEntity(Inventory.class);

        Inventory inventory = inventoryClient.getInventory(productId);
        int quantity = inventory.getQuantity();
        updateInventoryObject(inventory);
        return quantity > 0 ?
                "Order Placed Successfully" :
                "Product Out Of Stock";
    }

    private void updateInventoryObject(Inventory inventory) {
        inventory.setQuantity(inventory.getQuantity() - 1);
        inventoryClient.updateInventory(inventory);
//        restClient.post()
//                .uri("http://localhost:8081/inventory")
//                .body(inventory)
//                .retrieve()
//                .toBodilessEntity();
    }
}
