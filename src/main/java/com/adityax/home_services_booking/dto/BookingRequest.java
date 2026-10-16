package com.adityax.home_services_booking.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record BookingRequest(

        @NotNull(message = "Service ID is required")
        @Positive(message = "Service ID must be greater than zero")
        Long serviceId,

        @NotBlank(message = "Name cannot be empty")
        @Size(max = 100, message = "Name must not exceed 100 characters")
        String name,

        @NotBlank(message = "Phone number is required")
        @Pattern(
                regexp = "^[0-9]{10}$",
                message = "Phone number must contain exactly 10 digits"
        )
        String phone,

        @NotBlank(message = "Address cannot be empty")
        @Size(max = 500, message = "Address must not exceed 500 characters")
        String address,

        @NotNull(message = "Booking date is required")
        @FutureOrPresent(message = "Booking date cannot be in the past")
        LocalDate date,

        @NotBlank(message = "Time slot is required")
        String timeSlot

) {
}

