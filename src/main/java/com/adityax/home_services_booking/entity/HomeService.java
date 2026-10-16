
package com.adityax.home_services_booking.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "home_services")
public class HomeService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 500)
    private String description;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal startingPrice;

    @Column(nullable = false, precision = 3, scale = 1)
    private BigDecimal rating;

    public HomeService() {
    }

    public HomeService(String name, String description,
                       BigDecimal startingPrice, BigDecimal rating) {
        this.name = name;
        this.description = description;
        this.startingPrice = startingPrice;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getStartingPrice() {
        return startingPrice;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartingPrice(BigDecimal startingPrice) {
        this.startingPrice = startingPrice;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }
}
