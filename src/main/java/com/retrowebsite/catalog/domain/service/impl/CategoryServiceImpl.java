package com.retrowebsite.catalog.domain.service.impl;

import com.retrowebsite.catalog.dto.category.CategoryDto;
import com.retrowebsite.catalog.dto.category.UpdateCategoryDto;
import com.retrowebsite.catalog.domain.entity.Category;
import com.retrowebsite.catalog.exception.CatalogException;
import com.retrowebsite.catalog.exception.CatalogExceptionEnum;
import com.retrowebsite.catalog.repository.CategoryRepository;
import com.retrowebsite.catalog.domain.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepo;

    @Override
    public Category createCategory(CategoryDto dto) {
        return categoryRepo.save(
                Category.builder()
                        .id(UUID.randomUUID())
                        .categoryName(dto.getCategoryName())
                        .build()
        );
    }

    @Override
    public Category updateCategory(UpdateCategoryDto dto) {
        Category category = categoryRepo.findById(dto.getId())
                .orElseThrow(() -> new CatalogException(CatalogExceptionEnum.CATEGORY_NOT_FOUND));

        category.setCategoryName(dto.getCategoryName());
        return category;
    }
}
