package com.example.civalueapi.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.civalueapi.model.Product;
import com.example.civalueapi.model.Shelves;
import com.example.civalueapi.repository.ProductRepository;
import com.example.civalueapi.repository.ShopperRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer {

    @Bean
    CommandLineRunner initData(ShopperRepository shopperRepository, ProductRepository productRepository) {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();

            // Load and parse the selves.json
            Shelves[] shoppers = mapper.readValue(new ClassPathResource("data/shelves.json").getInputStream(), Shelves[].class);
            shopperRepository.saveAll(List.of(shoppers));

            // Load and parse the products.json
            Product[] products = mapper.readValue(new ClassPathResource("data/products.json").getInputStream(), Product[].class);
            productRepository.saveAll(List.of(products));
        };
    }
}
