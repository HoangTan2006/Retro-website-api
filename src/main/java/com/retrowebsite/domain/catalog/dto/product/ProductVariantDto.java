package com.retrowebsite.domain.catalog.dto.product;

import com.retrowebsite.domain.catalog.valueobject.ProductState;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class ProductVariantDto {
    private String sku;
    private UUID sizeId;
    private UUID colorId;
    private ProductState productState;
    private BigDecimal salePrice;
}
