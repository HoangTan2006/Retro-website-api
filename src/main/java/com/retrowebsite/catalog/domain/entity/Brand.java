package com.retrowebsite.catalog.domain.entity;

import com.retrowebsite.catalog.exception.CatalogException;
import com.retrowebsite.catalog.exception.CatalogExceptionEnum;

public class Brand extends BaseEntity {
    private String brandName;

    public Brand(String brandName) {
        this.brandName = brandName;
    }

    public static Brand create(String brandName) {
        validBrandName(brandName);
        return new Brand(brandName);
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        validBrandName(brandName);
        this.brandName = brandName;
    }

    private static void validBrandName(String brandName) {
        if (brandName == null || brandName.isBlank()) {
            throw new CatalogException(CatalogExceptionEnum.BRAND_NAME_INVALID);
        }
    }


}
