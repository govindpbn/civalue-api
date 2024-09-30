package com.example.civalueapi.repository;

import com.example.civalueapi.model.Shelves;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopperRepository extends JpaRepository<Shelves, String> {
    List<Shelves> findByShelvesProductId(String productId);
}
