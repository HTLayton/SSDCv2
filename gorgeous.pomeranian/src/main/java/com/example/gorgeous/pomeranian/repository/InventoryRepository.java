package com.example.gorgeous.pomeranian.repository;

import com.example.gorgeous.pomeranian.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, String> {

    @Query(value = "Select * from inventory where sku = :sku", nativeQuery = true)
    List<Inventory> findBySKU(@Param("sku") String sku);


}
