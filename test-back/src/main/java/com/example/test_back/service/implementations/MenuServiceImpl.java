package com.example.test_back.service.implementations;

import com.example.test_back.entity.Menu;
import com.example.test_back.entity.Restaurant;
import com.example.test_back.repository.MenuRepository;
import com.example.test_back.repository.RestaurantRepository;
import com.example.test_back.service.MenuService;
import dto.request.PostMenuRequestDto;
import dto.response.PostMenuResponseDto;
import dto.response.RestaurantResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    public PostMenuResponseDto createMenu(PostMenuRequestDto dto) {
        Restaurant restaurant = restaurantRepository.findById(dto.getRestaurantId())
                .orElseThrow(() -> new IllegalArgumentException("해당 식당이 존재하지 않습니다."));

        Menu menu = Menu.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .restaurant(restaurant)
                .build();

        Menu saved = menuRepository.save(menu);

        return new PostMenuResponseDto(
                saved.getId(),
                saved.getName(),
                saved.getPrice(),
                saved.getDescription(),
                new RestaurantResponseDto(
                        restaurant.getId(),
                        restaurant.getName(),
                        restaurant.getAddress(),
                        restaurant.getPhoneNumber()
                )
        );
    }

    @Override
    public List<PostMenuResponseDto> getMenusByRestaurantId(Long restaurantId) {
        return menuRepository.findByRestaurantId(restaurantId).stream()
                .map(menu -> new PostMenuResponseDto(
                        menu.getId(),
                        menu.getName(),
                        menu.getPrice(),
                        menu.getDescription(),
                        new RestaurantResponseDto(
                                menu.getRestaurant().getId(),
                                menu.getRestaurant().getName(),
                                menu.getRestaurant().getAddress(),
                                menu.getRestaurant().getPhoneNumber()
                        )
                )).collect(Collectors.toList());
    }

    @Override
    public PostMenuResponseDto updateMenu(Long id, PostMenuRequestDto dto) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("메뉴가 존재하지 않습니다."));

        Restaurant restaurant = restaurantRepository.findById(dto.getRestaurantId())
                .orElseThrow(() -> new IllegalArgumentException("식당이 존재하지 않습니다."));

        menu.setName(dto.getName());
        menu.setPrice(dto.getPrice());
        menu.setDescription(dto.getDescription());
        menu.setRestaurant(restaurant);

        Menu updated = menuRepository.save(menu);

        return new PostMenuResponseDto(
                updated.getId(),
                updated.getName(),
                updated.getPrice(),
                updated.getDescription(),
                new RestaurantResponseDto(
                        restaurant.getId(),
                        restaurant.getName(),
                        restaurant.getAddress(),
                        restaurant.getPhoneNumber()
                )
        );
    }

    @Override
    public void deleteMenu(Long id) {
        menuRepository.deleteById(id);
    }
}
