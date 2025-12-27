package com.retrowebsite.catalog.domain.entity;

import com.retrowebsite.catalog.exception.CatalogException;
import com.retrowebsite.catalog.exception.CatalogExceptionEnum;

public class Category extends BaseEntity {
    private String categoryName;

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public static Category create(String categoryName) {
        validCateGoryName(categoryName);
        return new Category(categoryName);
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        validCateGoryName(categoryName);
        this.categoryName = categoryName;
    }

    private static void validCateGoryName(String categoryName) {
        if (categoryName == null || categoryName.isBlank()) {
            throw new CatalogException(CatalogExceptionEnum.BRAND_NAME_INVALID);
        }
    }
}
