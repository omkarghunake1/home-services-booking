package com.adityax.home_services_booking.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 10)
    private String phone;

    @Column(nullable = false, length = 500)
    private String address;

    @Column(name = "booking_date", nullable = false)
    private LocalDate date;

    @Column(name = "time_slot", nullable = false)
    private String timeSlot;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookingStatus status = BookingStatus.PENDING;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "service_id", nullable = false)
    private HomeService service;

    public Booking() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public HomeService getService() {
        return service;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public void setService(HomeService service) {
        this.service = service;
    }
}
