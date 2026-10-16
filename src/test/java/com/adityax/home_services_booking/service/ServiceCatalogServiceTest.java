package com.adityax.home_services_booking.service;

import com.adityax.home_services_booking.dto.ServiceResponse;
import com.adityax.home_services_booking.entity.HomeService;
import com.adityax.home_services_booking.repository.HomeServiceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ServiceCatalogServiceTest {

    @Mock
    private HomeServiceRepository serviceRepository;

    @InjectMocks
    private ServiceCatalogService service;

    @Test
    void searchShouldReturnMatchingServices() {
        HomeService cleaning = new HomeService(
                "Home Cleaning",
                "Professional home cleaning service",
                new BigDecimal("999.00"),
                new BigDecimal("4.8")
        );

        when(serviceRepository.findByNameContainingIgnoreCase("clean"))
                .thenReturn(List.of(cleaning));

        List<ServiceResponse> results = service.getAllServices("clean");

        assertEquals(1, results.size());
        assertEquals("Home Cleaning", results.get(0).name());

        verify(serviceRepository)
                .findByNameContainingIgnoreCase("clean");
    }
}

