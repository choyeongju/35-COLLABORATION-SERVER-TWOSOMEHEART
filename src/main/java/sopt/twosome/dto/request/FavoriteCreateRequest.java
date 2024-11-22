package sopt.twosome.dto.request;

import jakarta.validation.constraints.NotBlank;
import sopt.twosome.enums.CoffeeBean;
import sopt.twosome.enums.Size;
import sopt.twosome.enums.Temperature;
import sopt.twosome.enums.Togo;

public record FavoriteCreateRequest(
        @NotBlank(message = "음료 이름은 반드시 지정되어야 합니다.")
        String name,
        @NotBlank(message = "음료 가격은 반드시 지정되어야 합니다.")
        Long price,
        @NotBlank(message = "음료 온도는 반드시 지정되어야 합니다.")
        Temperature temperature,
        @NotBlank(message = "음료 사이즈는 반드시 지정되어야 합니다.")
        Size size,
        @NotBlank(message = "원두 종류는 반드시 지정되어야 합니다.")
        CoffeeBean coffeeBean,
        @NotBlank(message = "픽업 방식은 반드시 지정되어야 합니다.")
        Togo togo,
        Boolean personal
) {
}
