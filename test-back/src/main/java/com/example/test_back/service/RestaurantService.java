package com.example.test_back.service;

import dto.request.PostRestaurantRequestDto;
import dto.response.PostRestaurantResponseDto;

import java.util.List;

public interface RestaurantService {
    PostRestaurantResponseDto createRestaurant(PostRestaurantRequestDto dto);
    List<PostRestaurantResponseDto> getAllRestaurants();
    PostRestaurantResponseDto updateRestaurant(Long id, PostRestaurantRequestDto dto);
    void deleteRestaurant(Long id);
}
