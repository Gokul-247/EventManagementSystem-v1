package com.VenueMngt.VenueManagement.Service;

import com.VenueMngt.VenueManagement.Model.VenueCategoryRequest;
import com.VenueMngt.VenueManagement.Model.VenueCategoryResponse;

import java.util.List;

public interface VenueCategoryService {
    VenueCategoryResponse createCategory(VenueCategoryRequest categoryRequest);

    VenueCategoryResponse getCategoryById(Long categoryId);

    List<VenueCategoryResponse> getAllCategories();
}

