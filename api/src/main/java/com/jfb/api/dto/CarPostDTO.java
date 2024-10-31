package com.jfb.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
@JsonInclude
public record CarPostDTO(
        String model,
        String brand,
        String price,
        String description,
        String engineVersion,
        String city,
        String createDate,
        String ownerId,
        String ownerName,
        String ownerType,
        String contact
) {
}
