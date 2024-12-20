package com.EventMngt.EventManagement.Controller;

import com.EventMngt.EventManagement.Model.ApiResponse;
import com.EventMngt.EventManagement.Model.CategoryRequest;
import com.EventMngt.EventManagement.Model.CategoryResponse;
import com.EventMngt.EventManagement.Service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventcategory")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CategoryResponse>> createCategory(@RequestBody CategoryRequest categoryRequest) {
        CategoryResponse categoryResponse = categoryService.createCategory(categoryRequest);
        return new ResponseEntity<>(new ApiResponse<>(true, "Category created successfully", categoryResponse), HttpStatus.CREATED);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<ApiResponse<CategoryResponse>> getCategory(@PathVariable Long categoryId) {
        CategoryResponse categoryResponse = categoryService.getCategoryById(categoryId);
        return new ResponseEntity<>(new ApiResponse<>(true, "Category fetched successfully", categoryResponse), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CategoryResponse>>> getAllCategories() {
        List<CategoryResponse> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(new ApiResponse<>(true, "Categories fetched successfully", categories), HttpStatus.OK);
    }
}
