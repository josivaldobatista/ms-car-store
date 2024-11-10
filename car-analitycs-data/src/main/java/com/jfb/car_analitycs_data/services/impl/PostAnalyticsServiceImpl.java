package com.jfb.car_analitycs_data.services.impl;

import com.jfb.car_analitycs_data.dtos.CarPostDTO;
import com.jfb.car_analitycs_data.entities.BrandAnalytics;
import com.jfb.car_analitycs_data.entities.CarModelAnalytics;
import com.jfb.car_analitycs_data.entities.CarModelPrice;
import com.jfb.car_analitycs_data.repositories.BrandAnalyticsRepository;
import com.jfb.car_analitycs_data.repositories.CarModelAnalyticsRepository;
import com.jfb.car_analitycs_data.repositories.CarModelPriceRepository;
import com.jfb.car_analitycs_data.services.PostAnalyticsService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PostAnalyticsServiceImpl implements PostAnalyticsService {

    private final BrandAnalyticsRepository brandAnalyticsRepository;
    private final CarModelAnalyticsRepository carModelAnalyticsRepository;
    private final CarModelPriceRepository carModelPriceRepository;

    public PostAnalyticsServiceImpl(
            BrandAnalyticsRepository brandAnalyticsRepository,
            CarModelAnalyticsRepository carModelAnalyticsRepository,
            CarModelPriceRepository carModelPriceRepository) {
        this.brandAnalyticsRepository = brandAnalyticsRepository;
        this.carModelAnalyticsRepository = carModelAnalyticsRepository;
        this.carModelPriceRepository = carModelPriceRepository;
    }

    @Override
    public void saveDataAnalytics(CarPostDTO carPostDTO) {
        saveBrandAnalytics(carPostDTO.brand());
        saveCarModelAnalytics(carPostDTO.model());
        saveCarModelPriceAnalytics(carPostDTO.model(), carPostDTO.price());
    }

    private void saveBrandAnalytics(String brand) {
        brandAnalyticsRepository.findByBrand(brand).ifPresentOrElse(item -> {
            item.setPosts(item.getPosts() + 1);
            brandAnalyticsRepository.save(item);
        }, () -> {
            BrandAnalytics brandAnalytics = new BrandAnalytics();
            brandAnalytics.setBrand(brand);
            brandAnalytics.setPosts(1L);
            brandAnalyticsRepository.save(brandAnalytics);
        });
    }

    private void saveCarModelAnalytics(String carModel) {
        carModelAnalyticsRepository.findByModel(carModel).ifPresentOrElse(item -> {
            item.setPosts(item.getPosts() + 1);
            carModelAnalyticsRepository.save(item);
        }, () -> {
            CarModelAnalytics carModelAnalytics = new CarModelAnalytics();
            carModelAnalytics.setModel(carModel);
            carModelAnalytics.setPosts(1L);
            carModelAnalyticsRepository.save(carModelAnalytics);
        });
    }

    private void saveCarModelPriceAnalytics(String carModel, BigDecimal price) {
        CarModelPrice carModelPrice = new CarModelPrice();
        carModelPrice.setModel(carModel);
        carModelPrice.setPrice(price);
        carModelPriceRepository.save(carModelPrice);
    }
}
