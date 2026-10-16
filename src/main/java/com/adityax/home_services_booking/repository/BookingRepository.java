package com.adityax.home_services_booking.repository;

import com.adityax.home_services_booking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository
        extends JpaRepository<Booking, Long> {

    List<Booking> findAllByOrderByDateAsc();
}