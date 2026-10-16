package com.adityax.home_services_booking.config;

import com.adityax.home_services_booking.entity.HomeService;
import com.adityax.home_services_booking.repository.HomeServiceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class ServiceDataInitializer {

    @Bean
    CommandLineRunner loadServices(HomeServiceRepository repository) {
        return args -> {
            if (repository.count() > 0) {
                return;
            }

            List<HomeService> services = List.of(
                    new HomeService("Home Cleaning",
                            "Professional home cleaning service",
                            new BigDecimal("999.00"),
                            new BigDecimal("4.8")),

                    new HomeService("Plumbing",
                            "Repair leaks and install plumbing fixtures",
                            new BigDecimal("499.00"),
                            new BigDecimal("4.6")),

                    new HomeService("Electrician",
                            "Electrical repairs and installations",
                            new BigDecimal("399.00"),
                            new BigDecimal("4.7")),

                    new HomeService("AC Repair",
                            "Air conditioner inspection and repair",
                            new BigDecimal("599.00"),
                            new BigDecimal("4.5")),

                    new HomeService("Painting",
                            "Interior and exterior painting services",
                            new BigDecimal("1999.00"),
                            new BigDecimal("4.4")),

                    new HomeService("Carpentry",
                            "Furniture repair and woodwork",
                            new BigDecimal("499.00"),
                            new BigDecimal("4.5")),

                    new HomeService("Pest Control",
                            "Home pest inspection and treatment",
                            new BigDecimal("799.00"),
                            new BigDecimal("4.3")),

                    new HomeService("Washing Machine Repair",
                            "Washing machine diagnosis and repair",
                            new BigDecimal("449.00"),
                            new BigDecimal("4.6"))
            );

            repository.saveAll(services);
        };
    }
}

