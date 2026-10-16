package com.adityax.home_services_booking.service;

import com.adityax.home_services_booking.dto.ServiceResponse;
import com.adityax.home_services_booking.entity.HomeService;
import com.adityax.home_services_booking.exception.ResourceNotFoundException;
import com.adityax.home_services_booking.repository.HomeServiceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServiceCatalogService {

    private final HomeServiceRepository serviceRepository;

    public ServiceCatalogService(HomeServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Transactional(readOnly = true)
    public List<ServiceResponse> getAllServices(String search) {

        List<HomeService> services;

        if (search == null || search.isBlank()) {
            services = serviceRepository.findAll();
        } else {
            services = serviceRepository
                    .findByNameContainingIgnoreCase(search.trim());
        }

        return services.stream()
                .map(this::toResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public ServiceResponse getServiceById(Long id) {

        HomeService service = serviceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Service not found with ID: " + id
                ));

        return toResponse(service);
    }

    private ServiceResponse toResponse(HomeService service) {
        return new ServiceResponse(
                service.getId(),
                service.getName(),
                service.getDescription(),
                service.getStartingPrice(),
                service.getRating()
        );
    }
}

