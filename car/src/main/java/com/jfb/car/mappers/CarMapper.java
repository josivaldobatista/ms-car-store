package com.jfb.car.mappers;

import com.jfb.car.dtos.CarPostDTO;
import com.jfb.car.entities.CarPost;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    public CarPostDTO toDto(CarPost carPost) {
        return CarPostDTO.builder()
                .brand(carPost.getBrand())
                .city(carPost.getCity())
                .model(carPost.getModel())
                .description(carPost.getDescription())
                .engineVersion(carPost.getEngineVersion())
                .createDate(carPost.getCreateDate())
                .ownerName(carPost.getOwnerPost().getName())
                .price(carPost.getPrice())
                .build();
    }

    public CarPost toEntity(CarPostDTO carPostDTO) {
        CarPost carPost = new CarPost();
        carPost.setModel(carPostDTO.model());
        carPost.setBrand(carPostDTO.brand());
        carPost.setPrice(carPostDTO.price());
        carPost.setCity(carPostDTO.city());
        carPost.setDescription(carPostDTO.description());
        carPost.setEngineVersion(carPostDTO.engineVersion());
        carPost.setCreateDate(carPostDTO.createDate());

        return carPost;
    }
}
