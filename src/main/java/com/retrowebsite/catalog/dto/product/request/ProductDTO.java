package com.retrowebsite.catalog.dto.product.request;

import com.retrowebsite.catalog.domain.valueobject.ProductState;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
public class ProductDTO {
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
    private List<ProductVariantDTO> variants;
}
