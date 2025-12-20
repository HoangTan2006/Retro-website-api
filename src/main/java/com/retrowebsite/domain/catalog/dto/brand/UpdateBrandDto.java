package com.retrowebsite.domain.catalog.dto.brand;

import lombok.Getter;

import java.util.UUID;

@Getter
public class UpdateBrandDto {
    private UUID id;
    private String brandName;
}
