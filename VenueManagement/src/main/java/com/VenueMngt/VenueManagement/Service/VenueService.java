package com.VenueMngt.VenueManagement.Service;

import com.VenueMngt.VenueManagement.Model.VenueRequest;
import com.VenueMngt.VenueManagement.Model.VenueResponse;

import java.util.List;

public interface VenueService {
    VenueResponse createVenue(VenueRequest venueRequest);

    List<VenueResponse> getVenuesByCategory(String categoryName);
}
