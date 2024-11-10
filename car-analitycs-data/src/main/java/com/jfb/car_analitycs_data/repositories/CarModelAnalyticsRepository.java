package com.jfb.car_analitycs_data.repositories;

import com.jfb.car_analitycs_data.entities.CarModelAnalytics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarModelAnalyticsRepository extends JpaRepository<CarModelAnalytics, Long> {

    Optional<CarModelAnalytics> findByModel(String model);
}
