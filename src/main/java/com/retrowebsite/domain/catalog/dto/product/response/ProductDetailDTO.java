package com.retrowebsite.domain.catalog.dto.product.response;

import java.math.BigDecimal;

public record ProductDetailDTO(
        String productName,
        String thumbnail,
        String summary,
        String images,
        String descriptions,
        String categoryName,
        String brandName,
        BigDecimal salePrice,
        Integer discount
) {}

