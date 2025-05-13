package dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostMenuResponseDto {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private RestaurantResponseDto restaurant;
}
