package com.jfb.car.repositories;

import com.jfb.car.entities.OwnerPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerPostRepository extends JpaRepository<OwnerPost, Long> {
}
