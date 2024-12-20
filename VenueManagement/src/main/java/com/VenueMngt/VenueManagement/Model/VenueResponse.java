package com.VenueMngt.VenueManagement.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenueResponse {
    private Long id;
    private String name;
    private String location;
    private Integer capacity;
    private Double costPerHour;
    private String categoryName;

    public VenueResponse(Long id, String name, String location, Integer capacity, Double costPerHour, String categoryName) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.costPerHour = costPerHour;
        this.categoryName = categoryName;
    }
}

