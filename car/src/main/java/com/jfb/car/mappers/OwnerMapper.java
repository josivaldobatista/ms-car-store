package com.jfb.car.mappers;

import com.jfb.car.dtos.OwnerPostDTO;
import com.jfb.car.entities.OwnerPost;

public class OwnerMapper {

    public static OwnerPost toEntity(OwnerPostDTO ownerPostDTO) {
        OwnerPost ownerPost =  new OwnerPost();
        ownerPost.setName(ownerPostDTO.name());
        ownerPost.setType(ownerPostDTO.type());
        ownerPost.setContactNumber(ownerPostDTO.contactNumber());
        return ownerPost;
    }
}
