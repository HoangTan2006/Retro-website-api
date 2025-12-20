package com.retrowebsite.domain.catalog.service;

import com.retrowebsite.domain.catalog.dto.product.request.ListVariantDTO;
import com.retrowebsite.domain.catalog.dto.product.request.ProductInfoDTO;
import com.retrowebsite.domain.catalog.entity.Product;
import com.retrowebsite.domain.catalog.valueobject.ProductState;

import java.util.UUID;

public interface ProductService {
    Product addProduct(ProductInfoDTO createProductDTO);
    Product addRating(UUID id, int rating);
    Product addVariant(ListVariantDTO dto);
    Product changeProductState(UUID id, ProductState state);
    Product changeVariantState(UUID id, UUID variantId, ProductState state);
}
