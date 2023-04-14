package com.example.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/order/validateProduct/{productId}")
    public ResponseEntity<String> productStockCheck(@PathVariable(value = "productId") Long productId) {

        String productUrl = "http://localhost:8090/product/" + productId;
        ResponseEntity<String> productEntity = restTemplate.getForEntity(productUrl, String.class);

        return productEntity;
    }
}
