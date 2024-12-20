package com.VenueMngt.VenueManagement.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenueCategoryResponse {
    private Long id;
    private String name;

    public VenueCategoryResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
