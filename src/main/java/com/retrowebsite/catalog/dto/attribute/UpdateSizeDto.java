package com.retrowebsite.catalog.dto.attribute;

import lombok.Getter;

import java.util.UUID;

@Getter
public class UpdateSizeDto {
    private UUID id;
    private String sizeName;
}
