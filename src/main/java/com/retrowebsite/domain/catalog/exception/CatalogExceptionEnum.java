package com.retrowebsite.domain.catalog.exception;

public enum CatalogExceptionEnum {
    PRODUCT_NOT_FOUND("Product not found"),
    SALE_PRICE_INVALID("The sale price must be greater than or equal to 0."),
    DISCOUNT_INVALID("The discount must be greater than or equal to 0 and less than or equal to 100."),
    RATING_INVALID("Rating must be greater than or equal to 0 and less than or equal to 5."),
    VARIANT_NOT_FOUND("Product variant not found."),

    CATEGORY_NOT_FOUND("Category not found"),

    BRAND_NOT_FOUND("Brand not found"),

    COLOR_NOT_FOUND("Color not found"),
    COLOR_HEX_INVALID("Hexadecimal color codes must begin with the '#' character and have exactly 3 or 6 characters."),

    SIZE_NOT_FOUND("Size not found.");

    private String message;

    CatalogExceptionEnum(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
