package com.adityax.home_services_booking.repository;

import com.adityax.home_services_booking.entity.HomeService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HomeServiceRepository
        extends JpaRepository<HomeService, Long> {

    List<HomeService> findByNameContainingIgnoreCase(String name);
}
