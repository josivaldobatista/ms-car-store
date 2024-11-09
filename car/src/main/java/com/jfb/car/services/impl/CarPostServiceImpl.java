package com.jfb.car.services.impl;

import com.jfb.car.dtos.CarPostDTO;
import com.jfb.car.entities.CarPost;
import com.jfb.car.entities.OwnerPost;
import com.jfb.car.mappers.CarMapper;
import com.jfb.car.repositories.CarPostRepository;
import com.jfb.car.repositories.OwnerPostRepository;
import com.jfb.car.services.CarPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CarPostServiceImpl implements CarPostService {

    @Autowired
    private CarPostRepository carPostRepository;

    @Autowired
    private OwnerPostRepository ownerPostRepository;

    @Autowired
    private CarMapper carMapper;

    @Override
    public void newPostDetails(CarPostDTO carPostDTO) {
        CarPost carPost = carMapper.toEntity(carPostDTO);

        ownerPostRepository.findById(carPostDTO.ownerId()).ifPresentOrElse(item -> {
                    carPost.setOwnerPost(item);
                    carPost.setContact(item.getContactNumber());
                }, () -> {
                    throw new RuntimeException("OwnerPost with ID " + carPostDTO.ownerId() + " not found");
                }
        );

        carPostRepository.save(carPost);
    }

    @Override
    public List<CarPostDTO> getCarSales() {
        List<CarPostDTO> listCarsSales = new ArrayList<>();
        carPostRepository.findAll().forEach(item -> {
            listCarsSales.add(carMapper.toDto(item));
        });
        return listCarsSales;
    }

    @Override
    public void changeCarSale(CarPostDTO carPostDTO, Long id) {
        carPostRepository.findById(id).ifPresentOrElse(item -> {
                    item.setDescription(carPostDTO.description());
                    item.setContact(carPostDTO.contact());
                    item.setPrice(carPostDTO.price());
                    item.setBrand(carPostDTO.brand());
                    item.setEngineVersion(carPostDTO.engineVersion());
                    item.setModel(carPostDTO.model());

                    carPostRepository.save(item);
                }, () -> {
                    throw new NoSuchElementException();
                }
        );
    }

    @Override
    public void removeCarSale(Long id) {
        carPostRepository.deleteById(id);
    }
}
