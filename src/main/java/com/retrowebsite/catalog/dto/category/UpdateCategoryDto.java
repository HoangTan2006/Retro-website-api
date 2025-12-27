package com.retrowebsite.catalog.dto.category;

import lombok.Getter;

import java.util.UUID;

@Getter
public class UpdateCategoryDto {
    private UUID id;
    private String categoryName;
}
