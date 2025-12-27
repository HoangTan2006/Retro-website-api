package com.retrowebsite.catalog.domain.entity;

import com.retrowebsite.catalog.exception.CatalogException;
import com.retrowebsite.catalog.exception.CatalogExceptionEnum;

public class Size extends BaseEntity {
    private String sizeName;

    public Size(String sizeName) {
        this.sizeName = sizeName;
    }

    public static Size create(String sizeName) {
        validSizeName(sizeName);
        return new Size(sizeName);
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        validSizeName(sizeName);
        this.sizeName = sizeName;
    }

    private static void validSizeName(String sizeName) {
        if (sizeName == null || sizeName.isBlank()) {
            throw new CatalogException(CatalogExceptionEnum.SIZE_NAME_INVALID);
        }
    }
}
