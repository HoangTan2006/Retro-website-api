package com.retrowebsite.domain.catalog.dto.product;

import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class ListVariantDto {
    private UUID productId;
    private List<ProductVariantDto> variants;
}
