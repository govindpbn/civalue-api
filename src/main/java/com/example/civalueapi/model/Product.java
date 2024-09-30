package com.example.civalueapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @JsonProperty("productId")
    private String productId;
    @JsonProperty("category")
    private String category;
    @JsonProperty("brand")
    private String brand;

}
