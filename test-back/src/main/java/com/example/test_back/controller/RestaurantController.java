package com.example.test_back.controller;

import com.example.test_back.service.RestaurantService;
import dto.request.PostRestaurantRequestDto;
import dto.response.PostRestaurantResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<PostRestaurantResponseDto> createRestaurant(
            @RequestBody PostRestaurantRequestDto dto) {
        return ResponseEntity.ok(restaurantService.createRestaurant(dto));
    }

    @GetMapping
    public ResponseEntity<List<PostRestaurantResponseDto>> getAllRestaurants() {
        return ResponseEntity.ok(restaurantService.getAllRestaurants());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostRestaurantResponseDto> updateRestaurant(
            @PathVariable Long id,
            @RequestBody PostRestaurantRequestDto dto) {
        return ResponseEntity.ok(restaurantService.updateRestaurant(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.noContent().build();
    }
}
