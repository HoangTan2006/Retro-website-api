package com.retrowebsite.domain.catalog.exception;

public class CatalogException extends RuntimeException {
    private String errCode;

    public CatalogException(CatalogExceptionEnum productExceptionEnum) {
        super(productExceptionEnum.toString());
        this.errCode = productExceptionEnum.name();
    }
}
