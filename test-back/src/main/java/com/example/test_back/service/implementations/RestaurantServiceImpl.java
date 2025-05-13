package com.example.test_back.service.implementations;

import com.example.test_back.entity.Restaurant;
import com.example.test_back.repository.RestaurantRepository;
import com.example.test_back.service.RestaurantService;
import dto.request.PostRestaurantRequestDto;
import dto.response.PostRestaurantResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Override
    public PostRestaurantResponseDto createRestaurant(PostRestaurantRequestDto dto) {
        Restaurant restaurant = Restaurant.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .phoneNumber(dto.getPhoneNumber())
                .build();

        Restaurant saved = restaurantRepository.save(restaurant);

        return new PostRestaurantResponseDto(
                saved.getId(), saved.getName(), saved.getAddress(), saved.getPhoneNumber());
    }

    @Override
    public List<PostRestaurantResponseDto> getAllRestaurants() {
        return restaurantRepository.findAll().stream()
                .map(r -> new PostRestaurantResponseDto(
                        r.getId(), r.getName(), r.getAddress(), r.getPhoneNumber()))
                .collect(Collectors.toList());
    }

    @Override
    public PostRestaurantResponseDto updateRestaurant(Long id, PostRestaurantRequestDto dto) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("식당이 존재하지 않습니다."));

        restaurant.setName(dto.getName());
        restaurant.setAddress(dto.getAddress());
        restaurant.setPhoneNumber(dto.getPhoneNumber());

        Restaurant updated = restaurantRepository.save(restaurant);

        return new PostRestaurantResponseDto(
                updated.getId(), updated.getName(), updated.getAddress(), updated.getPhoneNumber());
    }

    @Override
    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }
}
