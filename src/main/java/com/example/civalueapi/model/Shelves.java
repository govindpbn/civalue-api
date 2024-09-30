package com.example.civalueapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Shelves {

    @Id
    @JsonProperty("shopperId")
    private String shopperId;

    @OneToMany(mappedBy = "shopper", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonProperty("shelf")
    private List<Shelf> shelves;

}
