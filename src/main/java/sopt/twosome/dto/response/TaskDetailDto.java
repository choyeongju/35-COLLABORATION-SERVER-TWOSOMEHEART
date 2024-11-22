package sopt.twosome.dto.response;

import lombok.Builder;

@Builder
public record TaskDetailDto(
        Long id,
        String name,
        String status,
        String description,
        int price,
        String caution,
        String nutrition,
        String allergy,
        String image_url
) {
}