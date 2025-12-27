package com.retrowebsite.catalog.domain.service.impl;

import com.retrowebsite.catalog.dto.product.request.ListVariantDTO;
import com.retrowebsite.catalog.dto.product.request.ProductDTO;
import com.retrowebsite.catalog.dto.product.request.ProductVariantDTO;
import com.retrowebsite.catalog.domain.entity.Product;
import com.retrowebsite.catalog.domain.entity.ProductVariant;
import com.retrowebsite.catalog.exception.CatalogException;
import com.retrowebsite.catalog.exception.CatalogExceptionEnum;
import com.retrowebsite.catalog.repository.*;
import com.retrowebsite.catalog.domain.service.ProductService;
import com.retrowebsite.catalog.domain.valueobject.ProductState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepo;
    private final CategoryRepository categoryRepo;
    private final BrandRepository brandRepo;
    private final SizeRepository sizeRepo;
    private final ColorRepository colorRepo;

    @Override
    @Transactional
    public Product addProduct(ProductDTO dto) {
        if (dto.getSalePrice().compareTo(BigDecimal.ZERO) < 0) {
            throw new CatalogException(CatalogExceptionEnum.SALE_PRICE_INVALID);
        }

        if (dto.getDiscount() < 0 || dto.getDiscount() > 100) {
            throw new CatalogException(CatalogExceptionEnum.DISCOUNT_INVALID);
        }

        Product newProduct = Product.builder()
                .id(UUID.randomUUID())
                .productName(dto.getProductName())
                .thumbnail(dto.getThumbnail())
                .summary(dto.getSummary())
                .images(dto.getImages())
                .descriptions(dto.getDescriptions())
                .category(categoryRepo.getReferenceById(dto.getCategoryId()))
                .brand(brandRepo.getReferenceById(dto.getBrandId()))
                .productState(dto.getProductState())
                .salePrice(dto.getSalePrice())
                .discount(dto.getDiscount())
                .reviewCount(0)
                .totalRating(0)
                .build();

        for (ProductVariantDTO variant : dto.getVariants()) {
            if (variant.getSalePrice().compareTo(BigDecimal.ZERO) <= 0) {
                throw new CatalogException(CatalogExceptionEnum.SALE_PRICE_INVALID);
            }
        }

        Set<ProductVariant> variant = dto.getVariants()
                .stream()
                .map( v -> ProductVariant.builder()
                        .id(UUID.randomUUID())
                        .product(newProduct)
                        .sku(v.getSku())
                        .size(sizeRepo.getReferenceById(v.getSizeId()))
                        .color(colorRepo.getReferenceById(v.getColorId()))
                        .productState(v.getProductState())
                        .salePrice(v.getSalePrice())
                        .build())
                .collect(Collectors.toSet());

        newProduct.addProductVariant(variant);

        return productRepo.save(newProduct);
    }

    @Override
    public Product addRating(UUID id, int rating) {
        if (rating < 0 || rating > 5) {
            throw new CatalogException(CatalogExceptionEnum.RATING_INVALID);
        }

        Product product = productRepo.findById(id)
                .orElseThrow(() -> new CatalogException(CatalogExceptionEnum.PRODUCT_NOT_FOUND));

        product.addRating(rating);
        return product;
    }

    @Override
    @Transactional
    public Product addVariant(ListVariantDTO dto) {
        for (ProductVariantDTO variantDTO : dto.getVariants()) {
            if (variantDTO.getSalePrice().compareTo(BigDecimal.ZERO) < 0) {
                throw new CatalogException(CatalogExceptionEnum.SALE_PRICE_INVALID);
            }
        }

        Product productRef = productRepo.getReferenceById(dto.getProductId());

        Set<ProductVariant> variants = dto.getVariants().stream()
                .map(variantDto -> ProductVariant.builder()
                        .id(UUID.randomUUID())
                        .product(productRef)
                        .sku(variantDto.getSku())
                        .size(sizeRepo.getReferenceById(variantDto.getSizeId()))
                        .color(colorRepo.getReferenceById(variantDto.getColorId()))
                        .productState(variantDto.getProductState())
                        .salePrice(variantDto.getSalePrice())
                        .build()).collect(Collectors.toSet());

        productRef.addProductVariant(variants);

        return productRepo.save(productRef);
    }

    @Override
    public Product changeProductState(UUID id, ProductState state) {
        Product product = productRepo.getReferenceById(id);
        product.setProductState(state);

        return productRepo.save(product);
    }

    @Override
    public Product changeVariantState(UUID id, UUID variantId, ProductState state) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new CatalogException(CatalogExceptionEnum.PRODUCT_NOT_FOUND));

        ProductVariant variant = product.getProductVariants()
                .stream()
                .filter(pv -> pv.getId().equals(variantId))
                .findFirst()
                .orElseThrow(() -> new CatalogException(CatalogExceptionEnum.VARIANT_NOT_FOUND));

        variant.setProductState(state);
        return product;
    }
}
