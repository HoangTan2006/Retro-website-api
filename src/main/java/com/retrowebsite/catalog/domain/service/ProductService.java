package com.retrowebsite.catalog.domain.service;

import com.retrowebsite.catalog.dto.product.request.ListVariantDTO;
import com.retrowebsite.catalog.dto.product.request.ProductDTO;
import com.retrowebsite.catalog.domain.entity.Product;
import com.retrowebsite.catalog.domain.valueobject.ProductState;

import java.util.UUID;

public interface ProductService {
    Product addProduct(ProductDTO dto);
    Product addRating(UUID id, int rating);
    Product addVariant(ListVariantDTO dto);
    Product changeProductState(UUID id, ProductState state);
    Product changeVariantState(UUID id, UUID variantId, ProductState state);
}
