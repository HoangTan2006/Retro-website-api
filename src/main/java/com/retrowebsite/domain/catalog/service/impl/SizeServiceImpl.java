package com.retrowebsite.domain.catalog.service.impl;

import com.retrowebsite.domain.catalog.dto.attribute.SizeDto;
import com.retrowebsite.domain.catalog.dto.attribute.UpdateSizeDto;
import com.retrowebsite.domain.catalog.entity.Size;
import com.retrowebsite.domain.catalog.exception.CatalogException;
import com.retrowebsite.domain.catalog.exception.CatalogExceptionEnum;
import com.retrowebsite.domain.catalog.repository.SizeRepository;
import com.retrowebsite.domain.catalog.service.SizeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SizeServiceImpl implements SizeService {

    private final SizeRepository sizeRepo;

    @Override
    public Size createSize(SizeDto dto) {
        return sizeRepo.save(
                Size.builder()
                        .id(UUID.randomUUID())
                        .sizeName(dto.getSizeName())
                        .build()
        );
    }

    @Override
    public Size updateSize(UpdateSizeDto dto) {
        Size size = sizeRepo.findById(dto.getId())
                .orElseThrow(() -> new CatalogException(CatalogExceptionEnum.SIZE_NOT_FOUND));

        size.setSizeName(dto.getSizeName());
        return size;
    }
}
