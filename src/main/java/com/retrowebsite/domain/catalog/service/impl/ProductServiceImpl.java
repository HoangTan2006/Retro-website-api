package com.retrowebsite.domain.catalog.service.impl;

import com.retrowebsite.domain.catalog.dto.product.request.ListVariantDTO;
import com.retrowebsite.domain.catalog.dto.product.request.ProductInfoDTO;
import com.retrowebsite.domain.catalog.entity.Product;
import com.retrowebsite.domain.catalog.entity.ProductVariant;
import com.retrowebsite.domain.catalog.exception.CatalogException;
import com.retrowebsite.domain.catalog.exception.CatalogExceptionEnum;
import com.retrowebsite.domain.catalog.repository.*;
import com.retrowebsite.domain.catalog.service.ProductService;
import com.retrowebsite.domain.catalog.valueobject.ProductState;
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
    public Product addProduct(ProductInfoDTO dto) {
        if (dto.getSalePrice().compareTo(BigDecimal.ZERO) < 0) {
            throw new CatalogException(CatalogExceptionEnum.SALE_PRICE_INVALID);
        }

        if (dto.getDiscount() < 0 || dto.getDiscount() > 100) {
            throw new CatalogException(CatalogExceptionEnum.DISCOUNT_INVALID);
        }

        return productRepo.save(
            Product.builder()
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
                    .build()
        );
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
        if (dto.getVariants().stream().anyMatch(p -> p.getSalePrice().compareTo(BigDecimal.ZERO) < 0)) {
            throw new CatalogException(CatalogExceptionEnum.SALE_PRICE_INVALID);
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
