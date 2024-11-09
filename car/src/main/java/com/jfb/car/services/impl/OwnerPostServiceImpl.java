package com.jfb.car.services.impl;

import com.jfb.car.dtos.OwnerPostDTO;
import com.jfb.car.entities.OwnerPost;
import com.jfb.car.mappers.OwnerMapper;
import com.jfb.car.repositories.OwnerPostRepository;
import com.jfb.car.services.OwnerPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerPostServiceImpl implements OwnerPostService {

    @Autowired
    private OwnerPostRepository ownerPostRepository;

    @Override
    public void createOwner(OwnerPostDTO ownerPostDTO) {
        var teste = OwnerMapper.toEntity(ownerPostDTO);
        ownerPostRepository.save(teste);
    }
}
