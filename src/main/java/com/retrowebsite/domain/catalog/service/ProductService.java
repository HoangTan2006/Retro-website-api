package com.retrowebsite.domain.catalog.service;

import com.retrowebsite.domain.catalog.dto.product.ListVariantDto;
import com.retrowebsite.domain.catalog.dto.product.ProductInfoDto;
import com.retrowebsite.domain.catalog.entity.Product;
import com.retrowebsite.domain.catalog.valueobject.ProductState;

import java.util.UUID;

public interface ProductService {
    Product createProduct(ProductInfoDto createProductDTO);
    Product addRating(UUID id, int rating);
    Product addVariant(ListVariantDto dto);
    Product changeProductState(UUID id, ProductState state);
    Product changeVariantState(UUID id, UUID variantId, ProductState state);
}
