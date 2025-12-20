package com.retrowebsite.domain.catalog.dto.product;

import com.retrowebsite.domain.catalog.valueobject.ProductState;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class ProductInfoDto {
    private String productName;
    private String thumbnail;
    private String summary;
    private String images;
    private String descriptions;
    private UUID categoryId;
    private UUID brandId;
    private ProductState productState;
    private BigDecimal salePrice;
    private Integer discount;
}
