package com.example.test_back.service;

import dto.request.PostMenuRequestDto;
import dto.response.PostMenuResponseDto;

import java.util.List;

public interface MenuService {
    PostMenuResponseDto createMenu(PostMenuRequestDto dto);
    List<PostMenuResponseDto> getMenusByRestaurantId(Long restaurantId);
    PostMenuResponseDto updateMenu(Long id, PostMenuRequestDto dto);
    void deleteMenu(Long id);
}
