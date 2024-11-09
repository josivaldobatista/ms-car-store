package com.jfb.car.repositories;

import com.jfb.car.entities.CarPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarPostRepository extends JpaRepository<CarPost, Long> {
}
