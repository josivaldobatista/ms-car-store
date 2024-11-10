package com.jfb.car_analitycs_data.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
@JsonInclude
public record CarPostDTO(
        String model,
        String brand,
        BigDecimal price,
        String description,
        String engineVersion,
        String city,
        String createDate,
        Long ownerId,
        String ownerName,
        String ownerType,
        String contact
) {
}
