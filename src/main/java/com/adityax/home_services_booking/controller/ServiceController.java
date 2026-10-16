package com.adityax.home_services_booking.controller;

import com.adityax.home_services_booking.dto.ServiceResponse;
import com.adityax.home_services_booking.service.ServiceCatalogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    private final ServiceCatalogService serviceCatalogService;

    public ServiceController(ServiceCatalogService serviceCatalogService) {
        this.serviceCatalogService = serviceCatalogService;
    }

    @GetMapping
    public List<ServiceResponse> getAllServices(
            @RequestParam(required = false) String search) {

        return serviceCatalogService.getAllServices(search);
    }

    @GetMapping("/{id}")
    public ServiceResponse getServiceById(@PathVariable Long id) {
        return serviceCatalogService.getServiceById(id);
    }
}

