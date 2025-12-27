package com.retrowebsite.catalog.domain.service.impl;

import com.retrowebsite.catalog.dto.attribute.ColorDto;
import com.retrowebsite.catalog.dto.attribute.UpdateColorDto;
import com.retrowebsite.catalog.domain.entity.Color;
import com.retrowebsite.catalog.exception.CatalogException;
import com.retrowebsite.catalog.exception.CatalogExceptionEnum;
import com.retrowebsite.catalog.repository.ColorRepository;
import com.retrowebsite.catalog.domain.service.ColorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class ColorServiceImpl implements ColorService {

    private final ColorRepository colorRepo;

    @Override
    public Color createColor(ColorDto dto) {
        if (!validColorHex(dto.getColorHex())) {
            throw new CatalogException(CatalogExceptionEnum.COLOR_HEX_INVALID);
        }

        return colorRepo.save(
                Color.builder()
                        .id(UUID.randomUUID())
                        .colorName(dto.getColorName())
                        .colorHex(dto.getColorHex())
                        .build()
        );
    }

    @Override
    public Color updateColor(UpdateColorDto dto) {
        Color color = colorRepo.findById(dto.getId())
                .orElseThrow(() -> new CatalogException(CatalogExceptionEnum.COLOR_NOT_FOUND));

        color.setColorName(dto.getColorName());
        color.setColorHex(dto.getColorHex());
        return color;
    }


}
