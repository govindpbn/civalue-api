package com.example.civalueapi.service;

import com.example.civalueapi.model.Product;
import com.example.civalueapi.model.Shelf;
import com.example.civalueapi.model.Shelves;
import com.example.civalueapi.repository.ProductRepository;
import com.example.civalueapi.repository.ShopperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShopperService {

    @Autowired
    private ShopperRepository shopperRepository;

    @Autowired
    private ProductRepository productRepository;

    @Cacheable(value = "shopper-products", key = "#shopperId")
    public List<Shelf> getProductsByShopper(String shopperId, Optional<String> category, Optional<String> brand, int limit) {
        Shelves shopper = shopperRepository.findById(shopperId).orElseThrow(() -> new RuntimeException("Shopper not found"));

        List<Shelf> filteredShelves = shopper.getShelves().stream()
                .filter(shelf -> {
                    Optional<Product> productOpt = productRepository.findById(shelf.getProductId());
                    if (productOpt.isEmpty()) {
                        return false;
                    }

                    Product product = productOpt.get();
                    boolean categoryMatches = category.map(cat -> product.getCategory().equals(cat)).orElse(true);
                    boolean brandMatches = brand.map(br -> product.getBrand().equals(br)).orElse(true);

                    return categoryMatches && brandMatches;
                })
                .limit(limit)
                .collect(Collectors.toList());

        return filteredShelves;
    }

    public List<Shelves> getShoppersByProduct(String productId, int limit) {
        return shopperRepository.findByShelvesProductId(productId).stream()
                .limit(limit)
                .collect(Collectors.toList());
    }
}
