package sopt.twosome.dto.response;

import lombok.Builder;
import sopt.twosome.enums.Status;

@Builder
public record TaskDetailDto(
        Long id,
        String name,
        Status status,
        String description,
        int price,
        String caution,
        String nutrition,
        String allergy,
        String image_url
) {
}