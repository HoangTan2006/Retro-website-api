package com.retrowebsite.catalog.dto.product.request;

import com.retrowebsite.catalog.domain.valueobject.ProductState;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class ProductVariantDTO {
    private String sku;
    private UUID sizeId;
    private UUID colorId;
    private ProductState productState;
    private BigDecimal salePrice;
}
