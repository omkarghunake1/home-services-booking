package com.adityax.home_services_booking.controller;

import com.adityax.home_services_booking.dto.BookingRequest;
import com.adityax.home_services_booking.dto.BookingResponse;
import com.adityax.home_services_booking.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookingResponse createBooking(
            @Valid @RequestBody BookingRequest request) {

        return bookingService.createBooking(request);
    }

    @GetMapping
    public List<BookingResponse> getAllBookings() {
        return bookingService.getAllBookings();
    }


    @PatchMapping("/{id}/cancel")
    @ResponseStatus(HttpStatus.OK)
    public BookingResponse cancelBooking(@PathVariable Long id) {
        return bookingService.cancelBooking(id);
    }

}
