package sopt.twosome.dto.request;

import jakarta.validation.constraints.NotNull;
import sopt.twosome.enums.CoffeeBean;
import sopt.twosome.enums.Size;
import sopt.twosome.enums.Temperature;
import sopt.twosome.enums.Togo;

public record FavoriteCreateRequest(
        @NotNull(message = "음료 이름은 반드시 지정되어야 합니다.")
        String name,
        @NotNull(message = "음료 가격은 반드시 지정되어야 합니다.")
        Long price,
        @NotNull(message = "음료 온도는 반드시 지정되어야 합니다.")
        Temperature temperature,
        @NotNull(message = "음료 사이즈는 반드시 지정되어야 합니다.")
        Size size,
        @NotNull(message = "원두 종류는 반드시 지정되어야 합니다.")
        CoffeeBean coffeeBean,
        @NotNull(message = "픽업 방식은 반드시 지정되어야 합니다.")
        Togo togo,
        Boolean personal
) {
}
