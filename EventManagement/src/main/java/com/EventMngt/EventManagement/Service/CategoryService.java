package com.EventMngt.EventManagement.Service;

import com.EventMngt.EventManagement.Model.CategoryRequest;
import com.EventMngt.EventManagement.Model.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse createCategory(CategoryRequest categoryRequest);

    CategoryResponse getCategoryById(Long categoryId);

    List<CategoryResponse> getAllCategories();
}
