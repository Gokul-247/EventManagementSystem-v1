package com.VenueMngt.VenueManagement.Controller;

import com.VenueMngt.VenueManagement.Model.ApiResponse;
import com.VenueMngt.VenueManagement.Model.VenueRequest;
import com.VenueMngt.VenueManagement.Model.VenueResponse;
import com.VenueMngt.VenueManagement.Service.VenueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/venues")
public class VenueController {

    private final VenueService venueService;

    public VenueController(VenueService venueService) {
        this.venueService = venueService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<VenueResponse>> createVenue(@RequestBody VenueRequest venueRequest) {
        VenueResponse venueResponse = venueService.createVenue(venueRequest);
        return new ResponseEntity<>(new ApiResponse<>(true, "Venue created successfully", venueResponse), HttpStatus.CREATED);
    }

    @GetMapping("/category/{categoryName}")
    public ResponseEntity<ApiResponse<List<VenueResponse>>> getVenuesByCategory(@PathVariable String categoryName) {
        List<VenueResponse> venues = venueService.getVenuesByCategory(categoryName);
        return new ResponseEntity<>(new ApiResponse<>(true, "Venues fetched successfully", venues), HttpStatus.OK);
    }
}

