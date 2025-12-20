package com.retrowebsite.domain.catalog.service.impl;

import com.retrowebsite.domain.catalog.dto.attribute.ColorDto;
import com.retrowebsite.domain.catalog.dto.attribute.UpdateColorDto;
import com.retrowebsite.domain.catalog.entity.Color;
import com.retrowebsite.domain.catalog.exception.CatalogException;
import com.retrowebsite.domain.catalog.exception.CatalogExceptionEnum;
import com.retrowebsite.domain.catalog.repository.ColorRepository;
import com.retrowebsite.domain.catalog.service.ColorService;
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

    private boolean validColorHex(String colorHex) {
        Pattern pattern = Pattern.compile("^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$");

        Matcher matcher = pattern.matcher(colorHex);
        return matcher.matches();
    }
}
