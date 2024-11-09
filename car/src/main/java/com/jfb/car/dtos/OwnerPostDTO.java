package com.jfb.car.dtos;

import lombok.Builder;

@Builder
public record OwnerPostDTO(
        String name,
        String type,
        String contactNumber
) {
}
