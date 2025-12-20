package com.retrowebsite.domain.catalog.dto.product.request;

import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class ListVariantDTO {
    private UUID productId;
    private List<ProductVariantDTO> variants;
}
