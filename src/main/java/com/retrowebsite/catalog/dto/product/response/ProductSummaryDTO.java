package com.retrowebsite.catalog.dto.product.response;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductSummaryDTO(
    UUID id,
    String productName,
    String summary,
    BigDecimal salePrice
) {}