package com.retrowebsite.catalog.domain.valueobject;

import com.retrowebsite.catalog.exception.CatalogException;
import com.retrowebsite.catalog.exception.CatalogExceptionEnum;

import java.util.Objects;

public class Sku {
    private String sku;

    public Sku(String sku) {
        this.sku = sku;
    }

    public static Sku create(String sku) {
        validSku(sku);
        return new Sku(sku);
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        validSku(sku);
        this.sku = sku;
    }

    private static void validSku(String sku) {
        if (sku == null || sku.isBlank()) {
            throw new CatalogException(CatalogExceptionEnum.SKU_INVALID);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Sku sku1 = (Sku) o;
        return Objects.equals(sku, sku1.sku);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(sku);
    }
}
