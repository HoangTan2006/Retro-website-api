package com.retrowebsite.domain.catalog.service;

import com.retrowebsite.domain.catalog.dto.category.CategoryDto;
import com.retrowebsite.domain.catalog.dto.category.UpdateCategoryDto;
import com.retrowebsite.domain.catalog.entity.Category;

public interface CategoryService {
    Category createCategory(CategoryDto dto);
    Category updateCategory(UpdateCategoryDto dto);
}
