package com.retrowebsite.application;

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
import com.retrowebsite.domain.catalog.valueobject.ProductState;

import java.util.List;
import java.util.UUID;

public interface CatalogUseCase {

    //=================== Product - Variant =================================
    List<ProductSummaryDTO> getListProductSummary();

    ProductDetailDTO getProductDetail(UUID id);

    void addProduct(ProductInfoDTO dto);

    void addVariant(UUID id, ListVariantDTO dto);

    void addRating(int rating);

    void changeProductState(ProductState state);

    void changeProductVariantState(ProductState state);
    //========================================================================



    //=================== Size - Color =======================================
    void addSize(SizeDto dto);

    void updateSize(UpdateSizeDto dto);

    void addColor(ColorDto dto);

    void updateColor(ColorDto dto);
    //========================================================================


    //=================== Category - Brand ===================================
    void addCategory(CategoryDto dto);
    void updateCategory(UpdateCategoryDto dto);

    void addBrand(BrandDto dto);
    void updateBrand(UpdateBrandDto dto);
    //========================================================================
}
