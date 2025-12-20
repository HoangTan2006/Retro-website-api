package com.retrowebsite.application.impl;

import com.retrowebsite.application.CatalogUseCase;
import com.retrowebsite.domain.catalog.dto.attribute.ColorDto;
import com.retrowebsite.domain.catalog.dto.attribute.SizeDto;
import com.retrowebsite.domain.catalog.dto.attribute.UpdateSizeDto;
import com.retrowebsite.domain.catalog.dto.brand.BrandDto;
import com.retrowebsite.domain.catalog.dto.brand.UpdateBrandDto;
import com.retrowebsite.domain.catalog.dto.category.CategoryDto;
import com.retrowebsite.domain.catalog.dto.category.UpdateCategoryDto;
import com.retrowebsite.domain.catalog.dto.product.request.ListVariantDTO;
import com.retrowebsite.domain.catalog.dto.product.request.ProductInfoDTO;
import com.retrowebsite.domain.catalog.dto.product.response.ProductDetailDTO;
import com.retrowebsite.domain.catalog.dto.product.response.ProductSummaryDTO;
import com.retrowebsite.domain.catalog.exception.CatalogException;
import com.retrowebsite.domain.catalog.exception.CatalogExceptionEnum;
import com.retrowebsite.domain.catalog.repository.ProductRepository;
import com.retrowebsite.domain.catalog.service.ProductService;
import com.retrowebsite.domain.catalog.valueobject.ProductState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CatalogUseCaseImpl implements CatalogUseCase {

    private final ProductService productService;
    private final ProductRepository productRepo;

    @Override
    public List<ProductSummaryDTO> getListProductSummary() {
        return productRepo.findAllByProductState(ProductState.IN_STOCK);
    }

    @Override
    public ProductDetailDTO getProductDetail(UUID id) {
        return productRepo.findByIdAndProductState(id, ProductState.IN_STOCK)
                .orElseThrow(() -> new CatalogException(CatalogExceptionEnum.PRODUCT_NOT_FOUND));
    }

    @Override
    public void addProduct(ProductInfoDTO dto) {

    }

    @Override
    public void addVariant(UUID id, ListVariantDTO dto) {

    }

    @Override
    public void addRating(int rating) {

    }

    @Override
    public void changeProductState(ProductState state) {

    }

    @Override
    public void changeProductVariantState(ProductState state) {

    }

    @Override
    public void addSize(SizeDto dto) {

    }

    @Override
    public void updateSize(UpdateSizeDto dto) {

    }

    @Override
    public void addColor(ColorDto dto) {

    }

    @Override
    public void updateColor(ColorDto dto) {

    }

    @Override
    public void addCategory(CategoryDto dto) {

    }

    @Override
    public void updateCategory(UpdateCategoryDto dto) {

    }

    @Override
    public void addBrand(BrandDto dto) {

    }

    @Override
    public void updateBrand(UpdateBrandDto dto) {

    }
}
