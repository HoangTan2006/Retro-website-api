package com.retrowebsite.catalog.dto.attribute;

import lombok.Getter;

import java.util.UUID;

@Getter
public class UpdateColorDto {
    private UUID id;
    private String colorName;
    private String colorHex;
}
