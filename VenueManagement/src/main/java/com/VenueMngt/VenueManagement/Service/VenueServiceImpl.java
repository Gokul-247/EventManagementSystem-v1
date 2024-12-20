package com.VenueMngt.VenueManagement.Service;

import com.VenueMngt.VenueManagement.Entity.Venue;
import com.VenueMngt.VenueManagement.Entity.VenueCategory;
import com.VenueMngt.VenueManagement.Exception.VenueCategoryNotFoundException;
import com.VenueMngt.VenueManagement.Model.VenueRequest;
import com.VenueMngt.VenueManagement.Model.VenueResponse;
import com.VenueMngt.VenueManagement.Repository.VenueCategoryRepository;
import com.VenueMngt.VenueManagement.Repository.VenueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VenueServiceImpl implements VenueService {

    private final VenueRepository venueRepository;
    private final VenueCategoryRepository venueCategoryRepository;

    public VenueServiceImpl(VenueRepository venueRepository, VenueCategoryRepository venueCategoryRepository) {
        this.venueRepository = venueRepository;
        this.venueCategoryRepository = venueCategoryRepository;
    }

    @Override
    public VenueResponse createVenue(VenueRequest venueRequest) {
        VenueCategory category = venueCategoryRepository.findById(venueRequest.getCategoryId())
                .orElseThrow(() -> new VenueCategoryNotFoundException("Venue category not found"));

        Venue venue = new Venue();
        venue.setName(venueRequest.getName());
        venue.setLocation(venueRequest.getLocation());
        venue.setCapacity(venueRequest.getCapacity());
        venue.setCostPerHour(venueRequest.getCostPerHour());
        venue.setCategory(category);

        venue = venueRepository.save(venue);
        return mapToVenueResponse(venue);
    }

    @Override
    public List<VenueResponse> getVenuesByCategory(String categoryName) {
        List<Venue> venues = venueRepository.findByCategoryName(categoryName);
        return venues.stream()
                .map(this::mapToVenueResponse)
                .collect(Collectors.toList());
    }

    private VenueResponse mapToVenueResponse(Venue venue) {
        return new VenueResponse(
                venue.getId(),
                venue.getName(),
                venue.getLocation(),
                venue.getCapacity(),
                venue.getCostPerHour(),
                venue.getCategory().getName()
        );
    }
}
