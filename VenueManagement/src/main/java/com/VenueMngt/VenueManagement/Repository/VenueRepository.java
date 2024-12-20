package com.VenueMngt.VenueManagement.Repository;

import com.VenueMngt.VenueManagement.Entity.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Long> {
    List<Venue> findByCategoryName(String categoryName);
}
