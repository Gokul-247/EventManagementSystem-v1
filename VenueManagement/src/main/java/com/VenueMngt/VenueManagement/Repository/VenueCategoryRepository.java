package com.VenueMngt.VenueManagement.Repository;

import com.VenueMngt.VenueManagement.Entity.VenueCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueCategoryRepository extends JpaRepository<VenueCategory, Long> {
}
