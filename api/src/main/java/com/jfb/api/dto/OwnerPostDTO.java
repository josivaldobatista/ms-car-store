package com.jfb.api.dto;

import lombok.Builder;

@Builder
public record OwnerPostDTO(
        String name,
        String type,
        String contactNumber
) {
}
