package com.jfb.car_analitycs_data.repositories;

import com.jfb.car_analitycs_data.entities.BrandAnalytics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandAnalyticsRepository extends JpaRepository<BrandAnalytics, Long> {

    Optional<BrandAnalytics> findByBrand(String brand);
}
