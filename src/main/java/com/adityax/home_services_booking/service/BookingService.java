package com.adityax.home_services_booking.service;

import com.adityax.home_services_booking.dto.BookingRequest;
import com.adityax.home_services_booking.dto.BookingResponse;
import com.adityax.home_services_booking.entity.Booking;
import com.adityax.home_services_booking.entity.BookingStatus;
import com.adityax.home_services_booking.entity.HomeService;
import com.adityax.home_services_booking.exception.ResourceNotFoundException;
import com.adityax.home_services_booking.repository.BookingRepository;
import com.adityax.home_services_booking.repository.HomeServiceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final HomeServiceRepository serviceRepository;

    public BookingService(
            BookingRepository bookingRepository,
            HomeServiceRepository serviceRepository) {
        this.bookingRepository = bookingRepository;
        this.serviceRepository = serviceRepository;
    }

    @Transactional
    public BookingResponse createBooking(BookingRequest request) {

        HomeService service = serviceRepository
                .findById(request.serviceId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Service not found with ID: " + request.serviceId()
                ));

        Booking booking = new Booking();
        booking.setName(request.name().trim());
        booking.setPhone(request.phone());
        booking.setAddress(request.address().trim());
        booking.setDate(request.date());
        booking.setTimeSlot(request.timeSlot().trim());
        booking.setService(service);
        booking.setStatus(BookingStatus.PENDING);

        Booking savedBooking = bookingRepository.save(booking);

        return toResponse(savedBooking);
    }

    @Transactional(readOnly = true)
    public List<BookingResponse> getAllBookings() {

        return bookingRepository.findAllByOrderByDateAsc()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private BookingResponse toResponse(Booking booking) {

        return new BookingResponse(
                booking.getId(),
                booking.getService().getName(),
                booking.getName(),
                booking.getPhone(),
                booking.getAddress(),
                booking.getDate(),
                booking.getTimeSlot(),
                booking.getStatus()
        );
    }


    @Transactional
    public BookingResponse cancelBooking(Long id) {

        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Booking not found with ID: " + id
                ));

        if (booking.getStatus() != BookingStatus.PENDING) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Only pending bookings can be cancelled"
            );
        }

        booking.setStatus(BookingStatus.CANCELLED);

        Booking savedBooking = bookingRepository.save(booking);

        return toResponse(savedBooking);
    }

}

