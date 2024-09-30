package com.example.civalueapi.controller;

import com.example.civalueapi.model.Shelf;
import com.example.civalueapi.model.Shelves;
import com.example.civalueapi.service.ShopperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/shopper")
public class ShopperController {

    @Autowired
    private ShopperService shopperService;

    @GetMapping("/{shopperId}/products")
    public ResponseEntity<List<Shelf>> getProductsByShopper(
            @PathVariable String shopperId,
            @RequestParam Optional<String> category,
            @RequestParam Optional<String> brand,
            @RequestParam(defaultValue = "10") int limit) {

        List<Shelf> shelves = shopperService.getProductsByShopper(shopperId, category, brand, limit);
        return ResponseEntity.ok(shelves);
    }

    @GetMapping("/products/{productId}/shoppers")
    public ResponseEntity<List<Shelves>> getShoppersByProduct(
            @PathVariable String productId,
            @RequestParam(defaultValue = "10") int limit) {

        List<Shelves> shoppers = shopperService.getShoppersByProduct(productId, limit);
        return ResponseEntity.ok(shoppers);
    }
}
