package com.adityax.home_services_booking.dto;

import com.adityax.home_services_booking.entity.BookingStatus;

import java.time.LocalDate;

public record BookingResponse(
        Long id,
        String serviceName,
        String name,
        String phone,
        String address,
        LocalDate date,
        String timeSlot,
        BookingStatus status
) {
}

