package com.retrowebsite.catalog.domain.service;

import com.retrowebsite.catalog.dto.category.CategoryDto;
import com.retrowebsite.catalog.dto.category.UpdateCategoryDto;
import com.retrowebsite.catalog.domain.entity.Category;

public interface CategoryService {
    Category createCategory(CategoryDto dto);
    Category updateCategory(UpdateCategoryDto dto);
}
