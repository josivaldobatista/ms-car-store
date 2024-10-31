package com.jfb.api.services;

import com.jfb.api.dto.CarPostDTO;

import java.util.List;

public interface CarPostStoreService {

    List<CarPostDTO> getCarForSales();
    void changeCarForSale(CarPostDTO carPostDTO, String id);
    void removeCarForSale(String id);
}
