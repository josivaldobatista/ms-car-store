package com.jfb.car.services;

import com.jfb.car.dtos.CarPostDTO;

import java.util.List;

public interface CarPostService {

    void newPostDetails(CarPostDTO carPostDTO);
    List<CarPostDTO> getCarSales();
    void changeCarSale(CarPostDTO carPostDTO, Long id);
    void removeCarSale(Long postId);
}
