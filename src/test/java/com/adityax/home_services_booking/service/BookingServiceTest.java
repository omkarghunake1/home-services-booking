package com.adityax.home_services_booking.service;

import com.adityax.home_services_booking.dto.BookingRequest;
import com.adityax.home_services_booking.dto.BookingResponse;
import com.adityax.home_services_booking.entity.Booking;
import com.adityax.home_services_booking.entity.HomeService;
import com.adityax.home_services_booking.repository.BookingRepository;
import com.adityax.home_services_booking.repository.HomeServiceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookingServiceTest {

    @Mock
    private BookingRepository bookingRepository;

    @Mock
    private HomeServiceRepository serviceRepository;

    @InjectMocks
    private BookingService bookingService;

    @Test
    void createBookingShouldSavePendingBooking() {
        HomeService homeService = new HomeService(
                "Home Cleaning",
                "Professional cleaning",
                new BigDecimal("999.00"),
                new BigDecimal("4.8")
        );

        when(serviceRepository.findById(1L))
                .thenReturn(Optional.of(homeService));

        when(bookingRepository.save(any(Booking.class)))
                .thenAnswer(invocation -> {
                    Booking booking = invocation.getArgument(0);
                    return booking;
                });

        BookingRequest request = new BookingRequest(
                1L,
                "Rahul Patil",
                "9876543210",
                "Pune, Maharashtra",
                LocalDate.now().plusDays(1),
                "10:00 AM - 12:00 PM"
        );

        BookingResponse response =
                bookingService.createBooking(request);

        assertEquals("Home Cleaning", response.serviceName());
        assertEquals("PENDING", response.status().name());

        ArgumentCaptor<Booking> captor =
                ArgumentCaptor.forClass(Booking.class);

        verify(bookingRepository).save(captor.capture());

        assertEquals("Rahul Patil", captor.getValue().getName());
        assertEquals(homeService, captor.getValue().getService());
    }
}
