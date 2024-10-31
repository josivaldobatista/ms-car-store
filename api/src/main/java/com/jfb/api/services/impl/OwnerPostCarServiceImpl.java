package com.jfb.api.services.impl;

import com.jfb.api.clients.CarPostStoreClient;
import com.jfb.api.dto.OwnerPostDTO;
import com.jfb.api.services.OwnerPostService;
import org.springframework.stereotype.Service;

@Service
public class OwnerPostCarServiceImpl implements OwnerPostService {

    private final CarPostStoreClient carPostStoreClient;

    public OwnerPostCarServiceImpl(CarPostStoreClient carPostStoreClient) {
        this.carPostStoreClient = carPostStoreClient;
    }

    @Override
    public void createOwnerCar(OwnerPostDTO ownerPostDTO) {
        carPostStoreClient.ownerPostsClient(ownerPostDTO);
    }
}
