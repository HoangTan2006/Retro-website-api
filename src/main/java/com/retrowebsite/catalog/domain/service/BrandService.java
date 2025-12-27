package com.retrowebsite.catalog.domain.service;

import com.retrowebsite.catalog.dto.brand.BrandDto;
import com.retrowebsite.catalog.dto.brand.UpdateBrandDto;
import com.retrowebsite.catalog.domain.entity.Brand;

public interface BrandService {
    Brand createBrand(BrandDto dto);
    Brand updateBrandInfo(UpdateBrandDto dto);
}
