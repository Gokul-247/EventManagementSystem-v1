package com.VenueMngt.VenueManagement.Controller;

import com.VenueMngt.VenueManagement.Model.ApiResponse;
import com.VenueMngt.VenueManagement.Model.VenueCategoryRequest;
import com.VenueMngt.VenueManagement.Model.VenueCategoryResponse;
import com.VenueMngt.VenueManagement.Service.VenueCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/venue-categories")
public class VenueCategoryController {
    private final VenueCategoryService venueCategoryService;

    public VenueCategoryController(VenueCategoryService venueCategoryService) {
        this.venueCategoryService = venueCategoryService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<VenueCategoryResponse>> createVenueCategory(@RequestBody VenueCategoryRequest categoryRequest) {
        VenueCategoryResponse categoryResponse = venueCategoryService.createCategory(categoryRequest);
        return new ResponseEntity<>(new ApiResponse<>(true, "Venue category created successfully", categoryResponse), HttpStatus.CREATED);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<ApiResponse<VenueCategoryResponse>> getVenueCategory(@PathVariable Long categoryId) {
        VenueCategoryResponse categoryResponse = venueCategoryService.getCategoryById(categoryId);
        return new ResponseEntity<>(new ApiResponse<>(true, "Venue category fetched successfully", categoryResponse), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<VenueCategoryResponse>>> getAllVenueCategories() {
        List<VenueCategoryResponse> categories = venueCategoryService.getAllCategories();
        return new ResponseEntity<>(new ApiResponse<>(true, "Venue categories fetched successfully", categories), HttpStatus.OK);
    }
}

