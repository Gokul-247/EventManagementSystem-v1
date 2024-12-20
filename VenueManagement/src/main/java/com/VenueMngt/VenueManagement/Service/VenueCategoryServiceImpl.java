package com.VenueMngt.VenueManagement.Service;

import com.VenueMngt.VenueManagement.Entity.VenueCategory;
import com.VenueMngt.VenueManagement.Model.VenueCategoryRequest;
import com.VenueMngt.VenueManagement.Model.VenueCategoryResponse;
import com.VenueMngt.VenueManagement.Repository.VenueCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VenueCategoryServiceImpl implements VenueCategoryService {
    private final VenueCategoryRepository venueCategoryRepository;

    public VenueCategoryServiceImpl(VenueCategoryRepository venueCategoryRepository) {
        this.venueCategoryRepository = venueCategoryRepository;
    }

    @Override
    public VenueCategoryResponse createCategory(VenueCategoryRequest categoryRequest) {
        VenueCategory category = new VenueCategory();
        category.setName(categoryRequest.getName());
        category = venueCategoryRepository.save(category);
        return new VenueCategoryResponse(category.getId(), category.getName());
    }

    @Override
    public VenueCategoryResponse getCategoryById(Long categoryId) {
        VenueCategory category = venueCategoryRepository.findById(categoryId).orElseThrow();
        return new VenueCategoryResponse(category.getId(), category.getName());
    }

    @Override
    public List<VenueCategoryResponse> getAllCategories() {
        return venueCategoryRepository.findAll().stream()
                .map(category -> new VenueCategoryResponse(category.getId(), category.getName()))
                .collect(Collectors.toList());
    }
}
