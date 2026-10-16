package com.adityax.home_services_booking.dto;

import java.math.BigDecimal;

public record ServiceResponse(
        Long id,
        String name,
        String description,
        BigDecimal startingPrice,
        BigDecimal rating
) {
}

