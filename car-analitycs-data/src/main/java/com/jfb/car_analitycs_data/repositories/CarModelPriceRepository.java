package com.jfb.car_analitycs_data.repositories;

import com.jfb.car_analitycs_data.entities.CarModelPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarModelPriceRepository extends JpaRepository<CarModelPrice, Long> {
}
