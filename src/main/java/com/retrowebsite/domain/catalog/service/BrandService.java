package com.retrowebsite.domain.catalog.service;

import com.retrowebsite.domain.catalog.dto.brand.BrandDto;
import com.retrowebsite.domain.catalog.dto.brand.UpdateBrandDto;
import com.retrowebsite.domain.catalog.entity.Brand;

public interface BrandService {
    Brand createBrand(BrandDto dto);
    Brand updateBrandInfo(UpdateBrandDto dto);
}
