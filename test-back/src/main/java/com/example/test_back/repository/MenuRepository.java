package com.example.test_back.repository;

import com.example.test_back.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Menu> findByRestaurantId(Long restaurantId);
    List<Menu> findByRestaurant_Name(String name);
    List<Menu> findByPrice(Double price);
    List<Menu> findByDescription(String description);
}

