package com.retrowebsite.domain.catalog.service.impl;

import com.retrowebsite.domain.catalog.dto.brand.BrandDto;
import com.retrowebsite.domain.catalog.dto.brand.UpdateBrandDto;
import com.retrowebsite.domain.catalog.entity.Brand;
import com.retrowebsite.domain.catalog.exception.CatalogException;
import com.retrowebsite.domain.catalog.exception.CatalogExceptionEnum;
import com.retrowebsite.domain.catalog.repository.BrandRepository;
import com.retrowebsite.domain.catalog.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepo;

    @Override
    public Brand createBrand(BrandDto dto) {
        return brandRepo.save(
                Brand.builder()
                        .id(UUID.randomUUID())
                        .brandName(dto.getBrandName())
                        .build()
        );
    }

    @Override
    public Brand updateBrandInfo(UpdateBrandDto dto) {
        Brand brand = brandRepo.findById(dto.getId())
                .orElseThrow(() -> new CatalogException(CatalogExceptionEnum.BRAND_NOT_FOUND));

        brand.setBrandName(dto.getBrandName());
        return brand;
    }
}
