package com.retrowebsite.catalog.exception;

public class CatalogException extends RuntimeException {
    private String errCode;

    public CatalogException(CatalogExceptionEnum productExceptionEnum) {
        super(productExceptionEnum.toString());
        this.errCode = productExceptionEnum.name();
    }
}
