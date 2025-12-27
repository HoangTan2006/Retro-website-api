package com.retrowebsite.catalog.domain.service.impl;

import com.retrowebsite.catalog.dto.brand.BrandDto;
import com.retrowebsite.catalog.dto.brand.UpdateBrandDto;
import com.retrowebsite.catalog.domain.entity.Brand;
import com.retrowebsite.catalog.exception.CatalogException;
import com.retrowebsite.catalog.exception.CatalogExceptionEnum;
import com.retrowebsite.catalog.repository.BrandRepository;
import com.retrowebsite.catalog.domain.service.BrandService;
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
