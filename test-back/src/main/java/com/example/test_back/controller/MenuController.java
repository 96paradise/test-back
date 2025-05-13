package com.example.test_back.controller;

import com.example.test_back.service.MenuService;
import dto.request.PostMenuRequestDto;
import dto.response.PostMenuResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menus")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @PostMapping
    public ResponseEntity<PostMenuResponseDto> createMenu(@RequestBody PostMenuRequestDto dto) {
        return ResponseEntity.ok(menuService.createMenu(dto));
    }

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<PostMenuResponseDto>> getMenusByRestaurant(
            @PathVariable Long restaurantId) {
        return ResponseEntity.ok(menuService.getMenusByRestaurantId(restaurantId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostMenuResponseDto> updateMenu(
            @PathVariable Long id,
            @RequestBody PostMenuRequestDto dto) {
        return ResponseEntity.ok(menuService.updateMenu(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Long id) {
        menuService.deleteMenu(id);
        return ResponseEntity.noContent().build();
    }
}
