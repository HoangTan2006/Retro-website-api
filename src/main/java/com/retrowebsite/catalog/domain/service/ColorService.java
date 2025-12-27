package com.retrowebsite.catalog.domain.service;

import com.retrowebsite.catalog.dto.attribute.ColorDto;
import com.retrowebsite.catalog.dto.attribute.UpdateColorDto;
import com.retrowebsite.catalog.domain.entity.Color;

public interface ColorService {
    Color createColor(ColorDto dto);
    Color updateColor(UpdateColorDto dto);
}
