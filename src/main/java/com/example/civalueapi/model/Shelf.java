package com.example.civalueapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Shelf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("productId")
    private String productId;
    @JsonProperty("relevanceyScore")
    private double relevancyScore;

    @ManyToOne
    @JoinColumn(name = "shopper_id")
    @JsonProperty("shopperId")
    private Shelves shopper;

}
